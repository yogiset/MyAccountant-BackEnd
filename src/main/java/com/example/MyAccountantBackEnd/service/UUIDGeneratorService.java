package com.example.MyAccountantBackEnd.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UUIDGeneratorService {
    private static Set<Integer> generatedNumbers = new HashSet<>();
    public static String generateKaryawan() {
        String uuid = "KK";
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = random.nextInt(99999) + 1;
        } while (generatedNumbers.contains(randomNumber));

        // Add the generated number to the set
        generatedNumbers.add(randomNumber);
        String hexadecimalValue = Integer.toHexString(randomNumber);
        uuid += hexadecimalValue;
        return uuid;
    }
    public static String generateBarang() {
        String uuid = "KB";
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = random.nextInt(99999) + 1;
        } while (generatedNumbers.contains(randomNumber));

        // Add the generated number to the set
        generatedNumbers.add(randomNumber);
        String hexadecimalValue = Integer.toHexString(randomNumber);
        uuid += hexadecimalValue;
        return uuid;
    }
}
