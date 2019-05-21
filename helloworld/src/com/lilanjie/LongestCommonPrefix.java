package com.lilanjie;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return " ";
        }
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (j < strs[i].length()) {
                    char letter1 = strs[0].charAt(j);
                    char letter2 = strs[i].charAt(j);
                    if (letter1 != letter2) {
                        return strs[0].substring(0, j );
                    }
                }
                else {
                    return strs[0].substring(0, j );
                }
            }

        }
    return strs[0];
    }
}