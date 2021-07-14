package com.se.core.fake;

import java.util.Random;

public class Faker {

    private final static int max = 9;
    private final static int min = 0;

    private final char numerify = '#';
    private final char letterify_symbol = '?';


    public String letterify(String letterString) {
        if (letterString == null || letterString.indexOf(letterify_symbol) == -1) {
            return letterString;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < letterString.length(); i++) {
            char current = letterString.charAt(i);
            if (current == letterify_symbol) {
                current = getRandomAZ();
            }

            sb.append(current);
        }

        return sb.toString();
    }

    public String numerify(String numberString) {
        if (numberString == null || numberString.indexOf(numerify) == -1) {
            return numberString;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < numberString.length(); i++) {
            char current = numberString.charAt(i);
            if (current == numerify) {

                String randomNum = String.valueOf(getRandomNumber());
                current =  randomNum.charAt(0);
            }
                sb.append(current);

        }

        return sb.toString();
    }

    public String bothify(String string) {
        if (string == null || string.indexOf(numerify) == -1) {
            return string;
        }


        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current == letterify_symbol) {
                current = getRandomAZ();
            }
            else if (current == numerify) {
                String randomNum = String.valueOf(getRandomNumber());
                current =  randomNum.charAt(0);
            }

            sb.append(current);
        }

        return sb.toString();
    }


    private char getRandomAZ(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');

        return c;
    }

    private int getRandomNumber(){
        Random rand = new Random();
        int res =  rand.nextInt((9 - 0) + 1) + 0;

        return res;

    }
}
