package com.zr.dao.factory;

import com.zr.dao.TypeDao;

public class InstanceFactoryTypeDao {
    public TypeDao createTypeDao(){
        return new TypeDao();
    }
}
