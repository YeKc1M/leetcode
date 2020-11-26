package maximumgap;

import java.util.Arrays;

//https://leetcode-cn.com/problems/maximum-gap/
public class MaximumGap {
    public static void main(String[] args){
        System.out.println("x");
    }
}

class Solution {
    //
    public int maximumGap(int[] nums) {
        int res=0;
        if(nums.length<2) return 0;
        //
        return res;
    }
    //normal solution
    //pass
    public int maximumGap1(int[] nums) {
        int res=0;
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            res=Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }
}