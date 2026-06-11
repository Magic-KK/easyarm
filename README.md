# EasyArm

EasyArm 是一个 Android 快速开发框架示例工程，核心库模块为 `EasyFrame`，示例应用模块为 `app`。框架封装了基础 `Activity` / `Fragment`、MVP Presenter 注入、加载弹窗、Toast、MMKV、Gson、Glide 和日志等常用能力，适合在 AndroidX 项目中作为基础层复用。

## 项目结构

```text
easyarm
├── EasyFrame/      # 框架库模块
├── app/            # 示例应用模块
├── build.gradle    # 根 Gradle 配置
└── settings.gradle # 模块声明
```

当前工程使用 Android Gradle Plugin `4.0.0`、Gradle Wrapper `6.1.1`、Java 8、AndroidX。`EasyFrame` 的 `minSdkVersion` 为 `19`，示例 `app` 的 `minSdkVersion` 为 `21`。

## 接入方式

在同一工程内使用 `EasyFrame` 时，确认 `settings.gradle` 中包含库模块：

```gradle
include ':app'
include ':EasyFrame'
```

业务模块在 `build.gradle` 中依赖库模块：

```gradle
dependencies {
    implementation project(path: ':EasyFrame')
}
```

如果是新项目，还需要启用 AndroidX：

```properties
android.useAndroidX=true
android.enableJetifier=true
```

## 初始化

推荐让应用的 `Application` 继承 `BaseApp`，框架会初始化日志、Toast 和 MMKV。

```java
public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        // 示例项目在这里初始化网络层
        EasyNet.init(this);
    }
}
```

同时在 `AndroidManifest.xml` 中声明应用入口：

```xml
<application
    android:name=".App"
    ...>
</application>
```

如果不能继承 `BaseApp`，可以在自定义 `Application#onCreate()` 中手动调用：

```java
EasyLog.init();
EasyToast.initToast(this);
EasyMMKV.init(this);
```

## 基础页面

普通页面继承 `EasyBaseActivity`，通过模板方法完成布局、视图、监听和数据初始化。

```java
public class MainActivity extends EasyBaseActivity {
    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        showToast("页面初始化");
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }
}
```

`EasyBaseFragment` 的使用方式类似，实现 `getFragmentLayoutId()`、`initView(View)`、`initListener(View)` 和 `initData(View)` 即可。基础页面内可直接调用 `showToast()`、`showProgress()`、`hideProgress()`。

## MVP 使用

MVP 页面继承 `EasyBaseMvpActivity` 或 `EasyBaseMvpFragment`，使用 `@CreatePresenter` 创建 Presenter，使用 `@PresenterVariable` 注入 Presenter 字段。

```java
@CreatePresenter(presenter = {LoginPresenter.class})
public class LoginActivity extends EasyBaseMvpActivity<LoginPresenter> implements LoginView {

    @PresenterVariable
    LoginPresenter presenter;

    @Override
    public int getActivityLayoutId() {
        return R.layout.testb;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        findViewById(R.id.ss).setOnClickListener(v -> presenter.getLogin());
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void loginSuccess() {
        showToast("登录成功");
    }
}
```

View 层接口继承 `IBaseView`：

```java
public interface LoginView extends IBaseView {
    void loginSuccess();
}
```

Presenter 继承 `BasePresenter<V>`，在 `ModelBinding()` 中绑定 Model：

```java
public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel model;

    @Override
    public void ModelBinding() {
        model = new LoginModel(this);
    }

    public void getLogin() {
        model.getLogin();
    }

    public void result() {
        if (isAttachView()) {
            mView.loginSuccess();
        }
    }
}
```

Model 继承 `BaseModel<P>`：

```java
public class LoginModel extends BaseModel<LoginPresenter> {
    public LoginModel(LoginPresenter presenter) {
        super(presenter);
    }

    public void getLogin() {
        mPresenter.result();
    }
}
```

一个页面可以声明多个 Presenter：

```java
@CreatePresenter(presenter = {LoginPresenter.class, UserPresenter.class})
```

只有一个 Presenter 时，也可以通过 `getPresenter()` 获取第一个 Presenter；多个 Presenter 时可通过 `getPresenterProviders().getPresenter(index)` 按声明顺序获取。

## 常用工具

| 工具类 | 用途 |
| --- | --- |
| `EasyToast` | Toast 展示，`BaseApp` 初始化后可直接使用 |
| `EasyMMKV` | 基于 MMKV 的键值存储，支持 `String` 和 `int` 的保存、读取、清理 |
| `EasyGsonUtil` | JSON 字符串、Bean、List、Map 之间的转换，并对解析异常做容错 |
| `EasyGlideUtils` | 基于 Glide 加载网络图、本地文件、Uri、资源图和 View 背景 |
| `EasyLog` | 基于 XLog 的日志封装，提供 `d()`、`e()` 等方法 |

示例：

```java
EasyMMKV.save("user", "token", "abc");
String token = EasyMMKV.getString("user", "token", "");

String json = EasyGsonUtil.gsonString(user);
User parsed = EasyGsonUtil.gsonToBean(json, User.class);

EasyGlideUtils.load(this, imageUrl, imageView, R.drawable.main_brand_place_holder, R.drawable.main_brand_place_holder);
```

## 示例工程

示例应用位于 `app` 模块，包含：

- `App`：继承 `BaseApp` 并初始化示例网络层。
- `login/LoginActivity`：演示 MVP 注解创建和 Presenter 注入。
- `net/EasyNet`：演示 EasyHttp 的全局配置。

## 构建

使用仓库内 Gradle Wrapper 构建：

```bash
./gradlew :EasyFrame:assembleRelease
./gradlew :app:assembleDebug
```

如遇到本地 JDK 与旧版 Gradle 不兼容，请使用 Android Gradle Plugin 4.0.0 支持的 JDK 版本或在 Android Studio 中使用匹配的 Gradle JDK。
