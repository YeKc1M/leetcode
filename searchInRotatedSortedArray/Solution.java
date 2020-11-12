package searchInRotatedSortedArray;

import java.util.Arrays;

public class Solution {
    //normal solution 92%-5%
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0]==target? 0:-1;
        int res=-1;
        int left=0, right=nums.length, medium=(left+right)/2;
        while(left<=medium&&medium<right){
            if(target==nums[medium]) return medium;
            if(nums[left]<nums[medium]){
                //left is sorted
                if(target<nums[left]){
                    //search right
                    left=medium+1;
                    medium=(left+right)/2;
                }else{
                    //search left
                    res=sortedSearch(Arrays.copyOfRange(nums, left, medium), target);
                    if(res==-1){
                        left=medium+1;
                        medium=(left+right)/2;
                    }else return left+res;
                }
            }else{
                //right is sorted
                if(target>nums[right-1]){
                    //search left
                    right=medium;
                    medium=(left+right)/2;
                }else{
                    //search right
                    res=sortedSearch(Arrays.copyOfRange(nums, medium+1, right), target);
                    if(res==-1){
                        right=medium;
                        medium=(left+right)/2;
                    }else return medium+1+res;
                }
            }
        }
        return res;
    }
    public int sortedSearch(int[] nums, int target){
        if(nums.length==0) return -1;
        int left=0, right=nums.length, medium=(left+right)/2;
        while(left<=medium&&medium<right){
            if(nums[medium]==target) return medium;
            else if(target>nums[medium]){
                left=medium+1;
                medium=(left+right)/2;
            }else{
                right=medium;
                medium=(left+right)/2;
            }
        }
        return -1;
    }
    //answer provided by leetcode 92%-32%
    public int search1(int[] nums, int target){
        //find rotated index(smallest one)
        int left=0, right=nums.length, medium=(left+right)/2;
        int mIndex=0;
        while(left<=medium&&medium<right){
            if(nums[medium]>nums[(medium+1)%nums.length]){
                mIndex=(medium+1)%nums.length;
                break;
            }
            if(nums[left]<nums[medium]){
                left=medium+1;
                medium=(left+right)/2;
            }
            else{
                right=medium;
                medium=(left+right)/2;
            }
        }
        int res=-1;
        res=sortedSearch(Arrays.copyOfRange(nums, 0, mIndex), target);
        if(res!=-1) return res;
        res=sortedSearch(Arrays.copyOfRange(nums, mIndex, nums.length), target);
        return res==-1? -1: res+mIndex;
    }
    public static void main(String[] args){
        System.out.println("search in rotated sorted array");
        //pass normal solution
        //test();
        //test1();

        //sortedSearch() passes
        //testSortedSearch();
        //testSortedSearch1();

        //pass by leetcode
        //test2();
        //test3();
    }
    private static void test(){
        int[] arr={3};
        Solution s=new Solution();
        System.out.println(s.search(arr, 3));
    }
    private static void test1(){
        int[] arr={4,5,6,7,0,1,2};
        Solution s=new Solution();
        for(int i=0;i<9;i++){
            System.out.println(s.search(arr, i));
        }
    }
    private static void testSortedSearch(){
        int[] arr={1,3};
        Solution s=new Solution();
        for(int i=0;i<8;i++){
            System.out.println(s.sortedSearch(arr, i));
        }
    }
    private static void testSortedSearch1(){
        int[] arr={1,2,3,5,6,7};
        Solution s=new Solution();
        for(int i=0;i<9;i++){
            System.out.println(s.sortedSearch(arr, i));
        }
    }
    private static void test2(){
        int[] arr={3};
        Solution s=new Solution();
        System.out.println(s.search1(arr, 3));
    }
    private static void test3(){
        int[] arr={4,5,6,7,0,1,2};
        Solution s=new Solution();
        for(int i=0;i<9;i++){
            System.out.println(s.search1(arr, i));
        }
    }
}