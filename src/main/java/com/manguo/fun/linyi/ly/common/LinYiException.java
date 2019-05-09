package com.manguo.fun.linyi.ly.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther linyi
 * @email linyi4843@gmail.com
 */
@Getter
@AllArgsConstructor
public class LinYiException extends RuntimeException {

    private String message;

}
