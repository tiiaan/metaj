package com.tiiaan.tbm.metaj.common;

import java.util.concurrent.TimeUnit;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public class RedisConstants {

    public static final TimeUnit TTL_UNIT = TimeUnit.SECONDS;

    public static final String USER_TOKEN = "user:tok:";
    public static final Long USER_TOKEN_TTL = 1800L;

    public static final String STATUS_KEY = "stat:";
    public static final Long STATUS_TTL = 60000L;
    public static final String MAT = "0:";
    public static final String MOT = "1:";
    public static final String MF = "2:";
    public static final String BF = "3:";
    public static final String AP = "4:";
    public static final String AT = "5:";
    public static final String PP = "6:";
    public static final String PT = "7:";
    public static final String BT = "8:";
    public static final String BB = "9:";


    public static final String INSTANCE_TOKEN = "inst:tok:";
    public static final String INSTANCE_REGISTER_CODE = "inst:code:";
    public static final String INSTANCE_WATCHING_KEY = "inst:watch:";
    public static final String USER_WATCHING_KEY = "user:watch:";

    public static final String ISSUE_TRACKING_KEY = "issue:track:";
    public static final String USER_TRACKING_KEY = "user:track:";

    public static final String CACHE_INSTANCE_KEY = "cache:inst:";
    public static final Long CACHE_INSTANCE_TTL = 3600L;

    public static final String CACHE_ISSUE_KEY = "cache:issue:";
    public static final Long CACHE_ISSUE_TTL = 3600L;

    public static final String CACHE_INSTANCES_PAGE = "cache:inst:page:";
    public static final Long CACHE_INSTANCES_PAGE_TTL = 3600L;



    public static final String TRY_PUBLISH_LOCK_KEY = "lock:publish:try:";
    public static final Long TRY_PUBLISH_LOCK_TTL = 3600L;

    public static final String LO_PUBLISH_LOCK_KEY = "lock:publish:lo:";
    public static final Long LO_PUBLISH_LOCK_TTL = 300L;

    public static final String HI_PUBLISH_LOCK_KEY = "lock:publish:hi:";
    public static final Long HI_PUBLISH_LOCK_TTL = 1800L;

    public static final String FEED_KEY = "feed:";
    public static final Integer FEED_PAGE_SIZE = 10;

}
