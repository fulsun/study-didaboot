package top.fulsun.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fulsun
 * @title: DefinitionException
 * @projectName springbootdemo
 * @description: TODO
 * @date 2020/12/313:58:15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  DefinitionException  extends RuntimeException{
    private Integer errorCode;
    private String errorMessage;
}
