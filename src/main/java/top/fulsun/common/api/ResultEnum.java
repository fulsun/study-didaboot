package top.fulsun.common.api;

import lombok.Getter;

/**
 * @author fulsun
 * @title: ResultCode
 * @projectName springbootdemo
 * @description: 枚举了一些常用API操作码
 * @date 2020/12/311:22:31
 */
@Getter
public enum ResultEnum {
    TIME_OUT(130, "访问超时"),
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    VALIDATE_FAILED(404, "无法找到资源"),
    FORBIDDEN(403, "没有相关权限"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求方法"),
    SERVER_ERROR(500, " 服务器运行异常"),
    NOT_PARAM(10001, "参数不能为空"),
    NOT_EXIST_USER_OR_ERROR_PASSWORD(10002, "该用户不存在或密码错误"),
    NOT_PARAM_USER_OR_ERROR_PASSWORD(10003, "用户名或密码为空"),
    INTERNAL_SERVER_ERROR(9952, "内部服务错误，请联系管理员。");

    private Integer code;
    private String message;

    /**
     * 有参构造
     * @param code 响应码
     * @param message 响应消息
     */
    private ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
