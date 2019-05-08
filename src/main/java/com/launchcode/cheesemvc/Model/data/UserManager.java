package com.launchcode.cheesemvc.Model.data;

import com.launchcode.cheesemvc.Model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserManager {

    private static HashMap<Integer, User> userTable = new HashMap<>();

    public static Collection<User> getAll(){
        return userTable.values();
    }

    public static User getByID(int userID){
        return userTable.get(userID);
    }

    public static void create(String email, String userName, String pwd){


    }
}
