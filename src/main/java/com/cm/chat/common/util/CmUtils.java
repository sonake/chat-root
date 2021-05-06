package com.cm.chat.common.util;

import cn.hutool.core.lang.Snowflake;

/**
 * @ClassName CmUtils
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/30 10:25
 * @Version 1.0
 **/
public class CmUtils {

    public static String idWork(){
        Snowflake snowflake = new Snowflake(1,1);
        return snowflake.nextIdStr();
    }


    public static String idWork(int workerId,int dataCenterId){
        Snowflake snowflake = new Snowflake(workerId,dataCenterId);
        return snowflake.nextIdStr();
    }
}
