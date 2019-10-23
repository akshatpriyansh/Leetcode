package src.arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZigZagPattern {
	boolean state = true;
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        HashMap<Integer, ArrayList<Character>> hm = new HashMap<>();
        for(int i = 1; i<=numRows;i++){
            hm.put(i, new ArrayList<Character>());
        }
        int idx = 1;
        int sidx = 0;
        while(sidx < s.length()){
            System.out.println(idx);
            hm.get(idx).add(s.charAt(sidx));
            idx = getNewIdx(idx, state);
            
            if(idx == 0){
                state = true;
                idx = 2; 
            } else if(idx == numRows + 1) {
                state = false;
                idx = numRows-1;
            }
            sidx++;
        }
        
       StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,ArrayList<Character>> e : hm.entrySet()){
            ArrayList<Character> values = e.getValue();
            for(Character c : values){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    public int getNewIdx(int i, boolean state){
        if(state) return i+1;
        else return i-1;
    }
}

/*
 *	We have maintained a map for each index. We also have a switch variable.
 *	The switch variable will decide whether to go up or down. 
 * 
 *  In this question, we first have to traverse down the list and then add up the list.
 *  this can be done easily if we bound the index to the integer key in the map and add our element in that
 *  In this end we can collect all the elements in the arraylists and then return it in a stringbuilder
*/	