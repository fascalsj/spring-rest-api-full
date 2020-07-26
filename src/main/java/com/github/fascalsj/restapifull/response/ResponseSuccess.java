package com.github.fascalsj.restapifull.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ResponseSuccess<T> {
    private String result;
    private String message;
    private Date timestamp;
    private T data;
}
