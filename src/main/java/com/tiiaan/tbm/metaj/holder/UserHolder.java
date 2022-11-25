package com.tiiaan.tbm.metaj.holder;

import com.tiiaan.tbm.metaj.dto.UserDTO;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class UserHolder {

    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();


    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }

}
