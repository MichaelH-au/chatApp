package chatAPP.error;

public enum EmBusinessError implements CommonError {
    // common error type
    PARAMETER_VALIDATION_ERROR(10001, "Invalid parameters"),
    UNKNOWN_ERROR(10002, "Unknown error"),

    // User errors
    USER_NOT_EXIST(20001, "User is not exist"),
    INVALID_USERNAME_OR_PASSWORD(20002, "Invalid username or password")
    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
