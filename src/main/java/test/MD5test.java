package test;

import com.parking.system.util.MD5Code;

public class MD5test {
    public static void main(String[] args){
        System.out.println(new MD5Code().getMD5ofStr("123123"));
    }
}
