package com.customspring;

/**
 * Created by renwujie on 2018/06/12 at 22:55
 *
 * 只通过反射创建对象还不够，也要给对象进行属性注入。
 * spring对属性配置进行了封装。
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    //对象属性属于不可改变的时候，将其设置为final，再构造器中赋值，不提供set方法（提供也没用）

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
