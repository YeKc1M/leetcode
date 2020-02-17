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
    public static void main(String[] args){
        System.out.println("sort color");
    }
    private static void test(){
        int[] nums={1};
        //
    }
}