package com.health2gether.user;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHelper {

    private static String salt = BCrypt.gensalt(12);

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public static void main(String[] args) {
        String password = "flavio";
        String hashStoraged = hashPassword(password);

        System.out.println("Password: " + password);
        System.out.println("Hash: " + hashStoraged);
        System.out.println(checkPassword(password, hashStoraged));

    }
}
