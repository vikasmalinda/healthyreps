package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.exception.InvalidID;

public interface IPermissionDAO {
    public boolean isIDPresent(int id,String tableName) throws InvalidID;
    public int getLastID(String tableName); 
}
