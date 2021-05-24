package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.exception.InvalidId;

public interface IPermissionDAO {
    public boolean isIDPresent(int id,String tableName) throws InvalidId;
    public int getLastID(String tableName); 
}
