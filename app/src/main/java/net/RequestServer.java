package net;

import com.hjq.http.config.IRequestServer;
import com.hjq.http.model.BodyType;

public class RequestServer implements IRequestServer {

    @Override
    public String getHost() {
        return "https://www.baidu.com/";
    }

    @Override
    public BodyType getBodyType() {
        // 参数以 Json 格式提交（默认是表单）
        return BodyType.JSON;
    }
}
