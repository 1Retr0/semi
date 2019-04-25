package cn.edu.zucc.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNAUTHORIZED)
public class InvaildClientException extends RuntimeException {
    public InvaildClientException(String msg) {
        super(msg);
    }
}
