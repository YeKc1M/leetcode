package jumpGame;

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
    //dynamic programming 13%-19%
    public boolean canJump1(int[] nums){
        if(nums.length==0) return true;
        boolean[] isGood=new boolean[nums.length];
        isGood[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            isGood[i]=false;
            for(int j=i+1;j<=Math.min(nums.length-1, i+nums[i]);j++){
                if(isGood[j]){
                    isGood[i]=true;
                    break;
                }
            }
        }
        return isGood[0];
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