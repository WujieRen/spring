package com.cainiaossh.springfirst.manager.impl;

import com.cainiaossh.springfirst.manager.UserManager;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 16:25
 */
public class AnotherImplTest implements UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("___________________");
    }

    @Override
    public void delUser(int userId) {

    }

    @Override
    public String findUserById(int userId) {
        return null;
    }

    @Override
    public void modifyUser(int userId, String username, String password) {

    }
}
