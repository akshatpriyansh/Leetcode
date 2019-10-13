package strings;

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
