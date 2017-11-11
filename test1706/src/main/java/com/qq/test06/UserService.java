package com.qq.test06;

public class UserService {

    private UserDao userDao;

    public void addUser(User u)
    {
        this.userDao.save(u);
    }
    /**
     * @return the userDao
     */
    public UserDao getUserDao()
    {
        return userDao;
    }
    /**
     * @param userDao
     *            the userDao to set
     */
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
}
