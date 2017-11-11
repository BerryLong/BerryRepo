package com.qq.test06;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User u) {
        System.out.println("User:" + u.toString());
    }
    @Override
    public void delete() {
        System.out.println("delete User");

    }
}