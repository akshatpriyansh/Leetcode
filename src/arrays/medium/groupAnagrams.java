package src.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> hm = new HashMap<>();
        for(String s : strs){
            String parsed = parse(s);
            if(!hm.containsKey(parsed)) hm.put(parsed, new ArrayList());
            hm.get(parsed).add(s);
        }
        
        
        return new ArrayList(hm.values());
    }
    
    public String parse(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        return Arrays.toString(arr);
    }
	
    /*
     * There are multiple approaches.. brute force will cost N*N*K
Another way is to sort it, then it will be easier to compare strings as all anagrams will be the same. It will cost N* K logK

Since we cannot store hash maps as keys in hash maps ( too expensive), but we can store some kind of string which can do the same thing.



So for every string we can parse it into a count array. For example,String representation of parsed abcy will be
11100000000000000000000010
This can be used as string as every anagram will have same parsed representation. We can maintain a list for each parsed entity and return answer after adding all these lists.
     */
}
