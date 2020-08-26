package com.mt.common.exception;

import com.mt.common.core.CodeEnum;
import lombok.Getter;

/**
 * @author motb
 * @date 2019/7/20 18:18
 * @description
 */
@Getter
public class SysException extends RuntimeException {

    private final CodeEnum codeEnum;

    public SysException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.codeEnum = codeEnum;
    }
}
