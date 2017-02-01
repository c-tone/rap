package ctone.rap.constant;

/**
 * Created by ouyi on 16/9/26.
 */
public enum Status{
    SUCCESS(true,1,"success"),
    FAIL(false,-1,"fail")
    ;
    private boolean success;
    private int code;
    private String message;

    Status(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
