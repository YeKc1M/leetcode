
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums){//copy from leetcode
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List l=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i-1]==nums[i]) continue;
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List temp=new ArrayList<>();
                    temp.add(nums[i]);temp.add(nums[left]);temp.add(nums[right]);
                    l.add(temp);
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return l;
    }
    public static void main(String[] args){
        test();
        //testSort();
    }
    public static void test(){
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(new Solution().threeSum(nums));
    }
    public static void testSort(){
        int[] nums={-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}