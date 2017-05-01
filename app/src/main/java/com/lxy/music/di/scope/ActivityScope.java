package com.lxy.music.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lxy on 2017/5/1.
 * 自定义annotation
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
