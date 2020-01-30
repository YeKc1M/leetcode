import java.util.Arrays;

public class Solution {
    //normal solution 100%,22%
    public int[] searchRange(int[] nums, int target){
        int[] res={-1, -1};
        int medium=binarysearch(nums, target);
        if(medium!=-1){
            int i;
            for(i=medium;i>0&&nums[i]==nums[i-1];i--);
            res[0]=i;
            for(i=medium;i<nums.length-1&&nums[i]==nums[i];i++);
            res[1]=i+1;
        }
        return res;
    }
    //timeout
    public int[] searchRange1(int[] nums, int target) {
        int[] res={-1, -1};
        int medium=binarysearch(nums, target);
        if(medium==-1) return res;
        int r=medium;
        while(true){
            r=binarysearch(Arrays.copyOfRange(nums, 0, r), target);
            if(r==-1) break;
            else{
                res[0]=r;
            }
        }
        r=medium;
        while(true){
            r=binarysearch(Arrays.copyOfRange(nums, r+1, nums.length), target);
            if(r==-1) break;
            else res[1]=r;
        }
        return res;
    }
    public int binarysearch(int[] nums, int target){
        int left=0, right=nums.length, medium=(left+right)/2;
        while(left<=medium&&medium<right){
            if(nums[medium]==target) return medium;
            else if(target<nums[medium]){
                right=medium;
                medium=(left+right)/2;
            }else{
                left=medium+1;
                medium=(left+right)/2;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println("find first and last postion of element in sorted array");
        //
        //binarysearch() passed
        //testBinarySearch1();
        //testBinarySearch2();
    }
    private static void testBinarySearch1(){
        int[] a={1};
        Solution s=new Solution();
        for(int i=0;i<3;i++){
            System.out.println(s.binarysearch(a, i));
        }
    }
    private static void testBinarySearch2(){
        int[] a={1,3};
        Solution s=new Solution();
        for(int i=0;i<5;i++){
            System.out.println(s.binarysearch(a, i));
        }
    }
}