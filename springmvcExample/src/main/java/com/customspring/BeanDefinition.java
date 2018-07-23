package com.customspring;

/**
 * Created by renwujie on 2018/06/12 at 22:38
 *
 * spring的BeanFactory在创建对象时并不是直接读取xml文件中的配置，而是对bean的定义进行了封装也就是BeanDefinition。
 */
public class BeanDefinition {
    private String beanClassName;
    private Class beanClass;
    //bean的创建和装在由工厂完成，beanDefinition只维护此属性，不提供创建bean的方法
    private Object bean;
    private PropertyValues pvs;

    private String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        //一般通过class反射创建实例，但ioc目的是通过修改字符串达到调整实例的目的，故在设定classname的同时，修改beanClass的属性
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public PropertyValues getPvs() {
        return pvs;
    }

    public void setPvs(PropertyValues pvs) {
        this.pvs = pvs;
    }
}
