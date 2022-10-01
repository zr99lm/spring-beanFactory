package com.zr.dao.factory;

import com.zr.dao.UserDao;

public class UserDaoFactory {
//    静态工厂
    public static UserDao createUserDaos(){
        System.out.println("静态工厂方法");
        return new UserDao();
    }
    //非静态工厂不能直接调用
    public UserDao createUserDao(){
        System.out.println("非静态工厂方法");
        return new UserDao();
    }
}
