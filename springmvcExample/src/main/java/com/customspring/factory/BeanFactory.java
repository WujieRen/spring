package com.customspring.factory;

import com.customspring.BeanDefinition;

/**
 * Created by renwujie on 2018/06/12 at 23:04
 *
 * 有了beanDefinition，只要将其注册到工厂中，就可以获取到对象了。
 * 这里创建一个最简单的对象工厂，使用map管理beanDefinition，通过name获取对象。
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
    void registBeanDefinition(String name, BeanDefinition beanDefinition);
}
