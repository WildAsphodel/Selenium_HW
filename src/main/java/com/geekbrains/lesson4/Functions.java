package com.geekbrains.lesson4;

public class Functions {
    public static boolean isPrime(Integer number) {
        //2, 3, 4
        if (number <= 1) return false;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //2332
    //12321
    //1
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) return true;

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
        //12321
        //232
    }

    //isPalindrome(12321); == true
    //isPalindrome(232);  = true
    //isPalindrome(3); == true
}

