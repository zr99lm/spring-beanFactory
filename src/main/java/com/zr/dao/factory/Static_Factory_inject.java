package com.zr.dao.factory;

import com.zr.dao.TypeDao;

public  class Static_Factory_inject {
    public static TypeDao createTypeDao(){
        return new TypeDao();
    }
}
