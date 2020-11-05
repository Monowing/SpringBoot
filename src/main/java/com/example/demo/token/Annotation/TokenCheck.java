package com.example.demo.token.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {

    /**
     * check flag
     * true: check;false: not check;
     *
     * @return
     */
    public boolean check();

}
