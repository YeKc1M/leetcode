package firstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //normal solution 14%-5%
    public int firstMissingPositive(int[] nums){
        Set set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) set.add(nums[i]);
        }
        for(int i=1;;i++){
            if(!set.contains(i)) return i;
        }
    }
    //by leetcode
    public int firstMissingPositive1(int[] nums) {
        boolean has1=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                has1=true;
                break;
            }
        }
        if(!has1) return 1;
        if(nums.length==1) return 2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0||nums[i]>nums.length) nums[i]=1;
        }
        for(int i=0;i<nums.length;i++){
            int a=Math.abs(nums[i]);
            if(a==nums.length){
                nums[0]=-Math.abs(nums[0]);
            }else{
                nums[a]=-Math.abs(nums[a]);
            }
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0) return i;
        }
        if(nums[0]>0) return nums.length;
        return nums.length+1;
    }
    public static void main(String[] args){
        System.out.println("first missing positive");
        //test1();
        test2();
    }
    public static void test1(){
        int[] nums={7,8,9,11,12};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
    public static void test2(){
        int[] nums={1,2,0};
        System.out.println(new Solution().firstMissingPositive1(nums));
    }
}