package com.zr;

import com.zr.dao.UserDao;
import com.zr.service.UserService;
import com.zr.util.ApplicationPathContext;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationPathContext ac = new ApplicationPathContext("applicationcontext.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.UserDaoMethod();
        UserService userService = (UserService) ac.getBean("userService");
        userService.UserServiceMethod();
        HashMap<Character,Integer> charMap=new HashMap<>();
    }

}
