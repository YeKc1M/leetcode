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
    //unfinished
    public int firstMissingPositive1(int[] nums) {
        if(nums.length==0) return 1;
        if(nums.length==1) return nums[0]==1? 2:1;
        int min=0,min2=0;
        int s=0;
        //initilize min, min2
        for(;s<nums.length;s++){
            if(nums[s]>0){
                min=nums[s];
                s++;
                break;
            }
        }
        if(min==0) return 1;
        for(;s<nums.length;s++){
            if(nums[s]>0){
                min2=nums[s];
                s++;
                break;
            }
        }
        if(min2==0) return min==1? 2:1;
        Set set=new HashSet<>();
        return 0;
    }
    public static void main(String[] args){
        System.out.println("first missing positive");
        test1();
    }
    public static void test1(){
        int[] nums={7,8,9,11,12};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}