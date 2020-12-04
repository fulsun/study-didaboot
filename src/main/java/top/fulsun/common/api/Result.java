package top.fulsun.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.fulsun.common.exception.DefinitionException;

/**
 * @author fulsun
 * @title: Result
 * @projectName springbootdemo
 * @description: 封装API的错误码 通用返回对象
 * @date 2020/12/310:29:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code; // 状态码
    private String message; //提示消息
    private T data;// 数据

    /**
     * @param resultEnum 自定义枚举类，包含 code 和 message
     */
    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    /**
     * @param resultEnum 自定义枚举类，包含 code 和 message
     * @param data 数据
     */
    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }



    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;

    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Result<T> failed(Result errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> failed(String message) {
        return new Result<T>(ResultEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> Result<T> failed() {
        return failed(ResultEnum.FAILED.getMessage());
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return failed(ResultEnum.VALIDATE_FAILED.getMessage());
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(ResultEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), data);
    }

    /**
     * 自定义异常返回的结果
     * @param definitionException 自定义异常处理类
     * @return 返回自定义异常
     */
    public static Result<Object> defineError(DefinitionException definitionException) {
        return new Result<>(definitionException.getErrorCode(), definitionException.getErrorMessage());
    }

    /**
     * 其他异常处理方法返回的结果
     * @param resultEnum 自定义枚举类，包含 code 和 message
     * @return 返回其他异常
     */
    public static Result<Object> otherError(ResultEnum resultEnum) {
        return new Result<>(resultEnum);
    }
}
