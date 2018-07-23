package com.customspring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renwujie on 2018/06/12 at 22:59
 *
 * 存在多个属性注入，首先想到的应该是用list将propertyvalue管理起来。
 * 事实上spring也是这么做的，但是为了更灵活的属性注入，提供属性注入前后的操作，那么代理模式就可以用上了。
 *
 *
 * 用于载入前属性判断
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public void addValue(PropertyValue pv) {
        //此处进行注入前操作
        propertyValueList.add(pv);
    }

    public  List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
