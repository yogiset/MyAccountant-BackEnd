package com.example.MyAccountantBackEnd.service;

import java.util.Random;

public class UUIDGeneratorService {

    public static String generateKaryawan() {
        String uuid = "KK";
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 1;
        String hexadecimalValue = Integer.toHexString(randomNumber);
        uuid += hexadecimalValue;
        return uuid;
    }
    public static String generateBarang() {
        String uuid = "KB";
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 1;
        String hexadecimalValue = Integer.toHexString(randomNumber);
        uuid += hexadecimalValue;
        return uuid;
    }
}
