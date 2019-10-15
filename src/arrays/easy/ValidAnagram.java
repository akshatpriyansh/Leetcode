package src.arrays.easy;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            int[] slen = new int[256];
            int[] tlen = new int[256];

            for(char c : s.toCharArray()){
                slen[c-'a']++;
            }
            
            for(char c : t.toCharArray()){
                tlen[c-'a']++;
            }
            
            if(Arrays.equals(tlen, slen)) return true;            
        }
        
        return false;
    }
    
    /*
     * Two words are anagrams of each other if they contain the same number of characters.
     * We can keep their character count inside an array of ASCII length.
     * We can then return their comparison.
     */
}
