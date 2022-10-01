package com.zr.service;

import com.zr.dao.StudentDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentService {
    private StudentDao studentDao;
    private String host;
    private List<String> list=new ArrayList<>();
    private HashMap<Integer,String> map=new HashMap<>();

    @Override
    public String toString() {
        return "StudentService{" +
                "studentDao=" + studentDao  +
                ", host='" + host + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public void test(){
        System.out.println("StudentService method1");
        studentDao.test();

    }
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(HashMap<Integer, String> map) {
        this.map = map;
    }

    public StudentService(StudentDao studentDao, String host, List<String> list, HashMap<Integer, String> map) {
        this.studentDao = studentDao;
        this.host = host;
        this.list = list;
        this.map = map;
    }
}
