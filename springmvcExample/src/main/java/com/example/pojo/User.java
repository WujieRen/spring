package com.example.pojo;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by renwujie on 2018/05/08 at 14:15
 */
public class User {

    private int id;
    /*@NotNull*/
    @NotBlank(message = "用户名不能为空!")
    private String username;
    @Size(min = 2, max = 64, message = "昵称长度职能在2~64之间!")
    private String nickname;
    @Email(message = "不是有效的邮箱格式!")
    private String email;

    public User() {
    }

    public User(int id, String username, String nickname, String email) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
