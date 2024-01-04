package dev.prkprime;

import java.security.SecureRandom;

public class Main {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] args) {
        while (true) {
            CoreServerDemo.saveCube("cube_" + SECURE_RANDOM.nextInt(100));
        }
    }
}
