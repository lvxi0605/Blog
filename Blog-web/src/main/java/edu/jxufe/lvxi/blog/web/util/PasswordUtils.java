package edu.jxufe.lvxi.blog.web.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by lvxi on 2017/2/16.
 */
public  class PasswordUtils {

    /**
     * MD5加密密码
     * @param password 密码
     * @param salt 盐
     * @param hashlterations 迭代次数
     */
    public static String md5(String password,String salt,int hashlterations){
        Md5Hash md5Hash = new Md5Hash(password,salt,hashlterations);
        return md5Hash.toString();
    }
}
