package com.parking.system.util.Test;


import com.parking.system.util.MD5Code;


public class TestMD5Code {
    public static void main(String[] args){
        System.out.println(new MD5Code().getMD5ofStr("123123"));
    }
}
