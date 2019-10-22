package src.arrays.medium;

import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
    	int i = 0;
    	int j = 0;
    	ArrayList<int[]> al = new ArrayList<>();
    	
    	while(i < A.length && j < B.length) {
    		int f = Math.max(A[i][0], B[j][0]);
    		int l = Math.min(A[i][1], B[j][1]);
    		
    		if(f <= l) al.add(new int[] {f,l});
    		
    		if(A[i][1] > B[j][1]) {
    			j++;
    		} else {
    			i++;
    		}
    	}
    	
    	int[][] arr = new int[al.size()][2];
    	for(int x=0;x<al.size();x++) {
    		arr[x][0] = al.get(x)[0];
    		arr[x][1] = al.get(x)[1];
    	}
    	
    	return arr;
    }
}

/*
 * This problem is based on finding intervals. 

For finding intervals of two sets, given points (a,b) and (x,y) the formula is 
Interval = (Maximum of the start points, Minimum of the ending points)

Or, interval = (Math.max(a,x), Math.min(b,y))

After finding interval we can check if an array is not considerable anymore, i.e. its end point is now smaller than the other array’s end point.
We can then choose the next set from that array.

*/