package com.agclyy.better.algorithm.week01.homework;

import org.springframework.util.StringUtils;

/**
 * 242. Valid Anagram
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
