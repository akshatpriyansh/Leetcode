package src.strings.easy;

public class balancedStringSplit {
	public int balancedStringSplit(String s) {
        int balanceL = 0; int balanceR = 0;
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c == 'R') balanceR++;
            else balanceL++;
            
            if(balanceL == balanceR) ans++;
        }
        
        return ans;
    }
}

/**
 * O(n);
 * This question was poorly worded in the question and can be confused very easily.
 * For example, if finding maximum balanced strings in RRLRRLLLLRL, we can get RL, RRLL and LR. But the answer is RRLRRLRLLL and RL. 
 * This is simply counting both characters and increment ans whenever both of their counts match. 
 *
 * According to a leetcode user:
 * Here, we need to count the max number of balanced strings. Balanced strings are the ones having equal number of 'L' and 'R' characters. It does not matter whether they are consecutive or alternate or in any particular order. We just need to find substrings having equal number of 'L'/'R'.
 */
