# EasyArm

EasyArm is an Android quick-start framework sample. The reusable library module is `EasyFrame`, and the `app` module demonstrates how to use it. The framework wraps base `Activity` / `Fragment` classes, MVP Presenter injection, loading dialogs, Toast, MMKV, Gson, Glide, and logging helpers for AndroidX projects.

## Project Structure

```text
easyarm
├── EasyFrame/      # Framework library module
├── app/            # Demo application module
├── build.gradle    # Root Gradle configuration
└── settings.gradle # Module declarations
```

The current project uses Android Gradle Plugin `4.0.0`, Gradle Wrapper `6.1.1`, Java 8, and AndroidX. `EasyFrame` uses `minSdkVersion 19`; the demo app uses `minSdkVersion 21`.

## Installation

For local module usage, make sure `settings.gradle` includes the library module:

```gradle
include ':app'
include ':EasyFrame'
```

Then add the dependency in your app module:

```gradle
dependencies {
    implementation project(path: ':EasyFrame')
}
```

For a new project, enable AndroidX:

```properties
android.useAndroidX=true
android.enableJetifier=true
```

## Initialization

The recommended approach is to extend `BaseApp`. It initializes logging, Toast, and MMKV.

```java
public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        // The demo app initializes its network layer here.
        EasyNet.init(this);
    }
}
```

Register the application class in `AndroidManifest.xml`:

```xml
<application
    android:name=".App"
    ...>
</application>
```

If your application cannot extend `BaseApp`, call the initialization methods manually:

```java
EasyLog.init();
EasyToast.initToast(this);
EasyMMKV.init(this);
```

## Base Pages

Extend `EasyBaseActivity` and implement the template methods for layout, view, listener, and data initialization.

```java
public class MainActivity extends EasyBaseActivity {
    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        showToast("page initialized");
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
    }
}
```

`EasyBaseFragment` follows the same pattern with `getFragmentLayoutId()`, `initView(View)`, `initListener(View)`, and `initData(View)`. Base pages can call `showToast()`, `showProgress()`, and `hideProgress()` directly.

## MVP Usage

MVP pages extend `EasyBaseMvpActivity` or `EasyBaseMvpFragment`. Use `@CreatePresenter` to create Presenters and `@PresenterVariable` to inject Presenter fields.

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
        showToast("login success");
    }
}
```

The View contract extends `IBaseView`:

```java
public interface LoginView extends IBaseView {
    void loginSuccess();
}
```

The Presenter extends `BasePresenter<V>` and binds its Model in `ModelBinding()`:

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

The Model extends `BaseModel<P>`:

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

A page can declare multiple Presenters:

```java
@CreatePresenter(presenter = {LoginPresenter.class, UserPresenter.class})
```

For a single Presenter, `getPresenter()` returns the first Presenter. For multiple Presenters, use `getPresenterProviders().getPresenter(index)` by declaration order.

## Helpers

| Helper | Purpose |
| --- | --- |
| `EasyToast` | Toast helper, available after `BaseApp` initialization |
| `EasyMMKV` | MMKV key-value storage for `String` and `int` values |
| `EasyGsonUtil` | JSON, Bean, List, and Map conversion with exception tolerance |
| `EasyGlideUtils` | Glide wrappers for URLs, files, Uris, resources, and View backgrounds |
| `EasyLog` | XLog wrapper with `d()` and `e()` methods |

Example:

```java
EasyMMKV.save("user", "token", "abc");
String token = EasyMMKV.getString("user", "token", "");

String json = EasyGsonUtil.gsonString(user);
User parsed = EasyGsonUtil.gsonToBean(json, User.class);

EasyGlideUtils.load(this, imageUrl, imageView, R.drawable.main_brand_place_holder, R.drawable.main_brand_place_holder);
```

## Demo App

The demo app is in the `app` module:

- `App`: extends `BaseApp` and initializes the demo network layer.
- `login/LoginActivity`: demonstrates MVP Presenter creation and injection.
- `net/EasyNet`: demonstrates EasyHttp global configuration.

## Build

Use the Gradle Wrapper in this repository:

```bash
./gradlew :EasyFrame:assembleRelease
./gradlew :app:assembleDebug
```

If your local JDK is not compatible with the old Gradle version, use a JDK supported by Android Gradle Plugin 4.0.0 or select a matching Gradle JDK in Android Studio.
