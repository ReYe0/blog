package com.study.blog.utils;

import com.study.blog.enums.AppHttpCodeEnum;
import org.omg.CORBA.SystemException;
import org.springframework.lang.Nullable;

public class Assert {
    private Assert() {
    }

    /**
     * 断言对象不为空，为空则抛出异常
     *
     * @param object       对象
     * @param httpCodeEnum 状态码枚举类
     * @throws SystemException 系统异常
     */
    public static void notNull(@Nullable Object object, AppHttpCodeEnum httpCodeEnum) {
        if (object == null) {
//            throw new SystemException(httpCodeEnum);
            throw new com.study.blog.exception.SystemException(httpCodeEnum);
        }
    }

    /**
     * 断言对象为空，否则抛出异常
     *
     * @param object       对象
     * @param httpCodeEnum 状态码枚举类
     * @throws SystemException 系统异常
     */
    public static void isNull(Object object, AppHttpCodeEnum httpCodeEnum) {
        if (object != null) {
            throw new com.study.blog.exception.SystemException(httpCodeEnum);
        }
    }
}
