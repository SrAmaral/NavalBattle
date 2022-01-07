package br.com.Batalha.Naval;

import java.util.Locale;

public class Controler {
    public static int control(String key) {
        switch (key.toUpperCase()){
            case "A":
            case "0":
                return 1;
            case "B":
            case "1":
                return 2;
            case "C":
            case "2":
                return 3;
            case "D":
            case "3":
                return 4;
            case "E":
            case "4":
                return 5;
            case "F":
            case "5":
                return 6;
            case "G":
            case "6":
                return 7;
            case "H":
            case "7":
                return 8;
            case "I":
            case "8":
                return 9;
            case "J":
            case "9":
                return 10;
            default:
                return 0;
        }
    }
}
