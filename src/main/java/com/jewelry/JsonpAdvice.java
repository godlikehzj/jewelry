package com.jewelry;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by godlikehzj on 2017/11/5.
 */
@ControllerAdvice(basePackages = "com.jewelry.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice(){
        super("callback", "jsonp");
    }
}
