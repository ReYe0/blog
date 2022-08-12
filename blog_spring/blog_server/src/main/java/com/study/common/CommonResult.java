package com.study.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: blog
 * 返回信息体封装
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/8/7 20:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String code;
    private String message;
    private T data;

    //    public CommonResult(Integer code,String message){
//        this(code,message,null);
//    }
    public static CommonResult success(){
        return new CommonResult(Constants.CODE_200, "", null);
    }
    public static CommonResult success(Object data){
        return new CommonResult(Constants.CODE_200,"" , data);
    }
    public static CommonResult error(String code,String msg){
        return new CommonResult(code, msg, null);
    }
    public static CommonResult error(){
        return new CommonResult(Constants.CODE_500, "系统错误", null);
    }
}
