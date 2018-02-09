package com.parking.system.util.Validate;

/**
 * Created by 41988 on 2017/7/8.
 */
public class ValidateUtils {
    /**
     * 数据为空返回false.
     * */
    public static boolean validateEmpty(String data){
        if(data == null || data.equals("")){
            return false;
        }
        return true;
    }
}
