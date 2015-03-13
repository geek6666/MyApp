package com.zy.myapp.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2015/3/12.
 */

@Target({ElementType.METHOD, ElementType.FIELD})//元注解，用来负责注解其他的注解
@Retention(RetentionPolicy.RUNTIME)//注解作用范围
@Documented //用来标示是否生成文档
@Inherited //用来表示是否可以被集成
public @interface MethodInfo {
}
