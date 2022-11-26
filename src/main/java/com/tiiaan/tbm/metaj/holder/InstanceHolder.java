package com.tiiaan.tbm.metaj.holder;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class InstanceHolder {

    private static final ThreadLocal<Long> tid = new ThreadLocal<>();


    public static void saveInstanceId(Long id){
        tid.set(id);
    }

    public static Long getInstanceId(){
        return tid.get();
    }

    public static void removeInstanceId(){
        tid.remove();
    }
    
}
