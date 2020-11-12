package pascalsTriangle;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            int[] arr = new int[i+1];
            arr[0] = 1;
            if (i >= 1) {
                arr[i] = 1;
                for (int j = 1; j < i; j++) {
                    List l = (List) res.get(i-1);
                    arr[j] = (int) l.get(j) + (int) l.get(j - 1);
                }
            }
            List l=new LinkedList<>();
            for(int j: arr) l.add(j);
            res.add(l);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new Solution().generate(5));
    }
}