package org.example.traodoisub.config;


import org.apache.logging.log4j.ThreadContext;
import org.example.traodoisub.comon.SubConstants;
import org.example.traodoisub.logging.LogManage;
import org.example.traodoisub.logging.bases.ILogManage;
import org.example.traodoisub.logging.common.MessageLog;
import org.example.traodoisub.util.JsonConvertUtil;
import org.example.traodoisub.util.StringUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hieunt
 */
@ControllerAdvice
public class ResponseAdviceAdapter implements ResponseBodyAdvice {
    private static final ILogManage logManage = LogManage.getLogManage(ResponseAdviceAdapter.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest && response instanceof ServletServerHttpResponse) {
            String meThodName = null;
            if (returnType != null) {
                Method method = returnType.getMethod();
                if (method != null)
                    meThodName = method.getName();
            }
            if (MediaType.APPLICATION_JSON.equalsTypeAndSubtype(selectedContentType))
                logResponse(((ServletServerHttpRequest) request).getServletRequest(), body, meThodName);
        }

        return body;
    }

    public void logResponse(HttpServletRequest httpServletRequest, Object body, String meThodName) {
        MessageLog messageLog = new MessageLog();
        messageLog.setClassName(this.getClass().getName());
        messageLog.setMethodName(meThodName);
        messageLog.setPath(httpServletRequest.getRequestURI());
        Long startTime = 0L;
        String uuid = ThreadContext.get(SubConstants.UU_ID);
        try {
            String times = ThreadContext.get(SubConstants.START_TIME);
            if (StringUtil.isNotNullAndEmpty(times))
                startTime = Long.parseLong(times);
            Map messageMap = new HashMap();
            messageMap.put(SubConstants.FULL_RESPONSE, "Full log Response " + meThodName);
            messageMap.put(SubConstants.BODY, JsonConvertUtil.convertObjectToJson(body));

            messageLog.setMessages(messageMap);
            messageLog.setId(uuid);
            if (startTime != 0)
                messageLog.setDuration(System.currentTimeMillis() - startTime);
            logManage.info(messageLog);
        } catch (Exception ex) {
            messageLog.setId(uuid);
            messageLog.setMessage("logResponse - Error: " + ex.getMessage());
            messageLog.setException(ex);
            if (startTime != 0)
                messageLog.setDuration(System.currentTimeMillis() - startTime);

            logManage.error(messageLog, new LogManage.Configuration(true, false));
        }

    }

}
