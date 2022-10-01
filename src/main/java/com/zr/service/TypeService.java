package com.zr.service;

import com.zr.dao.TypeDao;
import com.zr.dao.factory.Static_Factory_inject;

public class TypeService {
    private TypeDao typeDao;

    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void test(){
        typeDao.test();
    }
}
