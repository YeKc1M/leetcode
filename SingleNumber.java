import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++) n^=nums[i];
        return n;
    }
    public int singleNumber1(int[] nums){
        HashSet set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        Object[] arr=set.toArray();
        return (int)arr[0];
    }
}