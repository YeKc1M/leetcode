package sortColor;

public class Solution {
    //normal solution 100% 5%
    public void sortColors(int[] nums) {
        int[] count=new int[3];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int index=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                nums[index++]=i;
                count[i]--;
            }
        }
    }
    //100% 5%
    public void sortColors1(int[] nums){
        int cursor=0,index0=0,index2=nums.length-1;
        while(index0<=index2&&nums[index0]==0){
            index0++;
            cursor++;
        }
        while(index0<=index2&&nums[index2]==2) index2--;
        while(cursor<=index2){
            if(nums[cursor]==0){
                nums[cursor]=nums[index0];
                nums[index0++]=0;
            }else if(nums[cursor]==2){
                nums[cursor]=nums[index2];
                nums[index2--]=2;
                if(nums[cursor]==0){
                    nums[cursor]=nums[index0];
                    nums[index0++]=0;
                }
                while(index0<=index2&&nums[index2]==2) index2--;
            }
            cursor++;
        }
    }
    public static void main(String[] args){
        System.out.println("sort color");
        test();
    }
    private static void test(){
        int[] nums={0,2,2,2,0,2,1,1};
        new Solution().sortColors1(nums);
    }
}