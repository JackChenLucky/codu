package cn.jack.codu.common.constants;

/**
 * 用户账号状态
 * @author JackChen
 *
 */
public enum UserStatus {

    OK(0, "启用"), FREEZED(1, "冻结"), DELETED(2, "被删除");

    int code;
    String message;

    UserStatus(int code, String message) {
        this.code = code;
        this.message = message;
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

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (UserStatus ms : UserStatus.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }
}
