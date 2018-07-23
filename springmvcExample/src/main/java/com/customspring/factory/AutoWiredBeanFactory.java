package com.customspring.factory;

import com.customspring.BeanDefinition;
import com.customspring.PropertyValue;
import com.customspring.PropertyValues;

import java.lang.reflect.Field;

/**
 * Created by renwujie on 2018/06/12 at 23:17
 */
public class AutoWiredBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(BeanDefinition beanDefinition) throws Exception {
        return null;
    }

    private Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        setPropertyValues(bean, beanDefinition.getPvs());
        return bean;
    }

    private void setPropertyValues(Object bean, PropertyValues pvs) throws Exception {
        if(pvs.getPropertyValueList().size() == 0) {
            return;
        }
        for(PropertyValue pv : pvs.getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(pv.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, pv.getValue());
        }
    }

}
