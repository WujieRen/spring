package com.cainiaossh.springfirst.manager;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 15:49
 */
public interface UserManager {
    void addUser(String userName, String password);

    void delUser(int userId);

    String findUserById(int userId);

    void modifyUser(int userId,String username,String password);
}
