package com.neklo.utils;

import com.neklo.annotations.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vladosby on 18.01.15.
 */
@Utils
public class HashPasswordImpl implements HashPassword {

    public String convertPasswordToHashCode(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuilder hash = new StringBuilder();

            for (int i = 0; i < byteData.length; i++) {
                hash.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return hash.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;
        }
    }
}