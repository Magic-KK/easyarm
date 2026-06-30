package net;

import com.hjq.http.config.IHttpPostBodyStrategy;
import com.hjq.http.config.IRequestServer;
import com.hjq.http.model.RequestBodyType;

public class RequestServer implements IRequestServer {

    @Override
    public String getHost() {
        return "https://www.baidu.com/";
    }

    @Override
    public IHttpPostBodyStrategy getBodyType() {
        // 参数以 Json 格式提交（默认是表单）
        return RequestBodyType.JSON;
    }
}
