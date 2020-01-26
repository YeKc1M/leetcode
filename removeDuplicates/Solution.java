import java.util.Arrays;

public class Solution{
    //normal solution
    public int removeDuplicates(int[] nums){
        if(nums.length<=1) return nums.length;
        int i=0,j=1;
        for(;j<nums.length;j++){
            if(nums[i]==nums[j]){
                continue;
            }else{
                nums[++i]=nums[j];
            }
        }
        nums=Arrays.copyOfRange(nums, 0, i+1);
        return i+1;
    }
    public static void main(String[] args){
        System.out.println("remove duplicates from sorted array");
        test();
    }
    private static void test(){
        int[] nums={1,1,2};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(nums);
    }
}