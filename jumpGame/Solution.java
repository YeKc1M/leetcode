public class Solution {
    //normal solution 62%-93%
    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        int mIndex=0;int temp=mIndex;
        do{
            temp=mIndex;
            if(mIndex+nums[mIndex]>=nums.length-1) return true;
            else{
                for(int i=temp+1;i<=temp+nums[temp];i++){
                    if(i+nums[i]>mIndex+nums[mIndex]){
                        mIndex=i;
                    }
                }
            }
        }while(mIndex!=temp);
        return false;
    }
    public static void main(String[] args){
        System.out.println("jump game");
        test();
    }
    private static void test(){
        int[] nums={2,3,1,1,4};
        System.out.println(new Solution().canJump(nums));
    }
}