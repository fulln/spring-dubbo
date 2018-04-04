package com.fulln.security.Encoding;

import org.springframework.security.crypto.password.PasswordEncoder;

public  class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        //数据加密
        String pass = null;
        try {
            pass = Des.encryptBasedDes(charSequence.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pass;
    }

    @Override
    public  boolean matches(CharSequence charSequence, String s) {
        //验证密码是否有效
        String pass1 = "" + charSequence.toString();
        String pass2 =Des.decryptBasedDes(s);
        return pass1.equals(pass2);
    }

}
