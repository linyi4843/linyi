package com.manguo.fun.linyi.ly.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther linyi
 * @email linyi4843@gmail.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    private static Result instance() {
        return new Result();
    }

    public static Result success() {
        Result result = instance();
        result.setCode(200);
        result.setMessage("ok");
        return result;
    }

    public static Result success(Object data) {
        Result result = instance();
        result.setCode(200);
        result.setMessage("ok");
        result.setData(data);
        return result;
    }

    public static Result error(Integer code, String message) {
        Result result = instance();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
