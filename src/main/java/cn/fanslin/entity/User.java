package cn.fanslin.entity;

import java.io.Serializable;

/**
 * Created by fanslin on 16/12/2.
 */
public class User implements Serializable{
    private String username;
    private Integer age;
    public User(){

    }
    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}
