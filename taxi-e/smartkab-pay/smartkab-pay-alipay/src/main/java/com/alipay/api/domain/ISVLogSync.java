package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class ISVLogSync extends AlipayObject {
    private static final long serialVersionUID = 8863488726999682686L;


    @ApiField("application")
    private String application;


    @ApiField("error_code")
    private String errorCode;


    @ApiField("error_msg")
    private String errorMsg;


    @ApiField("exception_stack_trace")
    private String exceptionStackTrace;


    @ApiField("execution_millis")
    private String executionMillis;


    @ApiField("interface_name")
    private String interfaceName;


    @ApiField("success")
    private String success;


    @ApiField("sync_type")
    private String syncType;


    @ApiField("timestamp")
    private String timestamp;


    public String getApplication() {
        /*  72 */
        return this.application;

    }


    public void setApplication(String application) {
        /*  75 */
        this.application = application;

    }


    public String getErrorCode() {
        /*  79 */
        return this.errorCode;

    }


    public void setErrorCode(String errorCode) {
        /*  82 */
        this.errorCode = errorCode;

    }


    public String getErrorMsg() {
        /*  86 */
        return this.errorMsg;

    }


    public void setErrorMsg(String errorMsg) {
        /*  89 */
        this.errorMsg = errorMsg;

    }


    public String getExceptionStackTrace() {
        /*  93 */
        return this.exceptionStackTrace;

    }


    public void setExceptionStackTrace(String exceptionStackTrace) {
        /*  96 */
        this.exceptionStackTrace = exceptionStackTrace;

    }


    public String getExecutionMillis() {
        /* 100 */
        return this.executionMillis;

    }


    public void setExecutionMillis(String executionMillis) {
        /* 103 */
        this.executionMillis = executionMillis;

    }


    public String getInterfaceName() {
        /* 107 */
        return this.interfaceName;

    }


    public void setInterfaceName(String interfaceName) {
        /* 110 */
        this.interfaceName = interfaceName;

    }


    public String getSuccess() {
        /* 114 */
        return this.success;

    }


    public void setSuccess(String success) {
        /* 117 */
        this.success = success;

    }


    public String getSyncType() {
        /* 121 */
        return this.syncType;

    }


    public void setSyncType(String syncType) {
        /* 124 */
        this.syncType = syncType;

    }


    public String getTimestamp() {
        /* 128 */
        return this.timestamp;

    }


    public void setTimestamp(String timestamp) {
        /* 131 */
        this.timestamp = timestamp;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ISVLogSync
 * JD-Core Version:    0.6.0
 */