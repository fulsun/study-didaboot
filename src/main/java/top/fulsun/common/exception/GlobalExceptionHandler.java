package top.fulsun.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.fulsun.common.api.Result;
import top.fulsun.common.api.ResultEnum;

/**
 * @author fulsun
 * @title: GlobalExceptionHandler
 * @projectName springbootdemo
 * @description: 自定义异常处理类
 * @date 2020/12/313:49:29
 */

// 开启全局异常捕获和返回Json @ResponseBody + @ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     * @return Result
     * @ExceptionHandler 说明捕获哪些异常，对那些异常进行处理。
     */
    @ExceptionHandler(DefinitionException.class)
    public Result<Object> customException(DefinitionException e) {
        return Result.defineError(e);
    }

    /**
     * 处理其他异常
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    public Result<Object> exceptionHandler(Exception e) {
        return Result.otherError(ResultEnum.INTERNAL_SERVER_ERROR);
    }
}
