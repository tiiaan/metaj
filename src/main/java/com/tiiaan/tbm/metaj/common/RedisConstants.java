package com.tiiaan.tbm.metaj.common;

import java.util.concurrent.TimeUnit;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class RedisConstants {

    public static final TimeUnit TTL_UNIT = TimeUnit.SECONDS;

    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 36000L;

    public static final String STATUS_KEY = "status:";
    public static final Long STATUS_TTL = 60000L;

    public static final String INSTANCE_TOKEN = "inst:tok:";
    public static final String INSTANCE_REGISTER_CODE = "inst:code:";

    public static final String CACHE_INSTANCE_KEY = "cache:inst:";
    public static final Long CACHE_INSTANCE_TTL = 4320L;

    public static final String INSTANCE_WATCHING_KEY = "inst:watch:";

}
