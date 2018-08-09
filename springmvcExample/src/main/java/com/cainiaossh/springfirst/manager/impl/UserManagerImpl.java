package com.cainiaossh.springfirst.manager.impl;

import com.cainiaossh.springfirst.manager.UserManager;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 15:49
 */
public class UserManagerImpl implements UserManager {

    //private UserDao userDao;
    //
    //public void setUserDao(UserDao userDao) {
    //    this.userDao = userDao;
    //}

    //
    ////	public UserManagerImpl(UserDao userDao) {
    ////
    ////		this.userDao = userDao;
    ////	}
    //
    //
    //@Override
    //public void addUser(String userName, String password) {
    //    userDao.addUser(userName, password);
    //}

    public void addUser(String username, String password) {
        //checkSecurity();
        System.out.println("UserManager.addUser");

    }

    public void delUser(int userId) {
        //checkSecurity();
        System.out.println("UserManager.delUser");

    }

    public String findUserById(int userId) {
        //checkSecurity();
        System.out.println("UserManager.findUserById");
        return	"张三";
    }

    public void modifyUser(int userId, String username, String password) {
        //checkSecurity();
        System.out.println("UserManager.modifyUser");

    }

}
