package ctone.rap.result;

import ctone.rap.constant.Status;

import java.io.Serializable;

/**
 * Created by ouyi on 16/9/26.
 * 返回结果
 */
public class Result implements Serializable{
    //if success
    private boolean success;
    //code number
    private int code;
    //call mssage
    private String message;
    //real data
    private Object data;

    public Result() {
        this.success = true;
        this.code = 0;
        this.message = "index......";
    }

    public void setStatus(boolean success, int code, String message){
        this.setSuccess(success);
        this.setCode(code);
        this.setMessage(message);
    }

    public void setStatus(Status status){
        this.setSuccess(status.isSuccess());
        this.setCode(status.getCode());
        this.setMessage(status.getMessage());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"success\":" + success +
                ",\"code\":" + code +
                ",\"message\":'" + message +
                ",\"data\":" + data +
                '}';
    }
}
