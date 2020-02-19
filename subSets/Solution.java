import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    //binary tree 15%-5%
    public List<List<Integer>> subsets(int[] nums){
        List res=new LinkedList<>();
        backtrace(res, new LinkedList<>(), 0, nums);
        return res;
    }
    private void backtrace(List res, List l, int n, int[] nums){
        if(n<nums.length){
            List temp=new LinkedList<>(l);
            backtrace(res, l, n+1, nums);
            temp.add(nums[n]);
            backtrace(res, temp, n+1, nums);
        }else{
            res.add(l);
        }
    }
    //normal solution timeout
    public List<List<Integer>> subsets1(int[] nums) {
        List res=new LinkedList<>();
        Set s=new HashSet<>();
        backtrace1(s, 0, nums);
        Iterator itr=s.iterator();
        while(itr.hasNext()){
            Set temp=(Set)itr.next();
            List add=new LinkedList<>();
            add.addAll(temp);
            res.add(add);
        }
        return res;
    }
    private void backtrace1(Set s, int n, int[] nums){
        Set add=new HashSet<>();
        if(n<nums.length){
            for(int i=0;i<n;i++){
                add.add(nums[i]);
            }
            s.add(add);
            for(int i=n;i<nums.length;i++){
                int temp=nums[n];
                nums[n]=nums[i];
                nums[i]=temp;
                backtrace1(s, n+1, nums);
                nums[i]=nums[n];
                nums[n]=temp;
            }
        }else{
            for(int i=0;i<n;i++){
                add.add(nums[i]);
            }
            s.add(add);
        }
    }
    public static void main(String[] args){
        System.out.println("sub sets");
        //test1();
        test();
    }
    private static void test1(){
        int[] nums={1,2,3,4};
        System.out.println(new Solution().subsets1(nums));
    }
    private static void test(){
        int[] nums={1,2,3,4};
        System.out.println(new Solution().subsets(nums));
    }
}