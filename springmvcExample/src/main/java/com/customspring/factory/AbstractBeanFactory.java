package com.customspring.factory;

import com.customspring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by renwujie on 2018/06/12 at 23:09
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) throws Exception {
        if(!beanDefinitionMap.containsKey(name) || beanDefinitionMap.get(name) == null) {
            throw new Exception("对象定义不存在!");
        }
        return beanDefinitionMap.get(name).getBean();
    }

    public void registBeanDefinition(String name, BeanDefinition beanDefinition) {
        if(beanDefinition == null) {
            return;
        }

        Object bean = null;
        try {
            bean = createBean(beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    protected abstract Object createBean(BeanDefinition beanDefinition) throws Exception;
}
