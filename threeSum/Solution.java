import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        HashSet set=new HashSet();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List add=new LinkedList();
                        add.add(nums[i]);
                        add.add(nums[j]);
                        add.add(nums[k]);
                        set.add(add);
                    }
                }
            }
        }
        List l=new LinkedList<>(set);
        return l;
    }
    public static void main(String[] args){
        test();
    }
    public static void test(){
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(new Solution().threeSum(nums));
    }
}