package com.cainiaossh.springfirst.client;

import com.cainiaossh.springfirst.dynamicproxy.SecurityHandler;
import com.cainiaossh.springfirst.manager.UserManager;
import com.cainiaossh.springfirst.manager.impl.AnotherImplTest;
import com.cainiaossh.springfirst.manager.impl.UserManagerImpl;

import java.lang.reflect.Proxy;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 15:48
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserManager userManager = (UserManager) factory.getBean("userManager");
        //userManager.addUser("renwujie", "23");
        SecurityHandler handler = new SecurityHandler();
        UserManager userManager = (UserManager) handler.createProxyInstance(new UserManagerImpl());

        userManager.addUser("remnwujie", "23");
        UserManager test = (UserManager) handler.createProxyInstance(new AnotherImplTest());
        test.addUser("remnwujie", "23");

        UserManager object = new UserManagerImpl();
        Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args1) -> method.invoke(object, args1));
        object.addUser("renwujie", "dd");
    }
}
