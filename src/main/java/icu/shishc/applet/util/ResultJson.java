package icu.shishc.applet.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 工具类：返回的JSON格式
 */
@Data
public class ResultJson implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final int RESULT_SUCCESS_CODE = 200;
    private static final int RESULT_SERVER_ERROR_CODE = 500;

    private static final String RESULT_SUCCESS_MESSAGE = "success";
    private static final String RESULT_FAIL_MESSAGE = "fail";

    private int code;
    private String message;
    private Object data;

    public ResultJson() {}
    public ResultJson(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultJson ok(Object data) {
        ResultJson result = new ResultJson();
        result.setCode(RESULT_SUCCESS_CODE);
        result.setMessage(RESULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static ResultJson ok() {
        return ResultJson.ok(null);
    }

    public static ResultJson fail() {
        ResultJson result = new ResultJson();
        result.setData(null);
        result.setCode(RESULT_SERVER_ERROR_CODE);
        result.setMessage(RESULT_FAIL_MESSAGE);
        return result;
    }

    public static ResultJson fail(int code, String msg) {
        ResultJson result = new ResultJson();
        result.setMessage(msg);
        result.setCode(code);
        result.setData(null);
        return result;
    }
}
