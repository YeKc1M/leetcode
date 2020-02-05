import java.util.LinkedList;
import java.util.List;

public class Solution {
    //normal solution 53%-29%
    public List<List<Integer>> permute(int[] nums) {
        List res=new LinkedList<>();
        boolean[] in=new boolean[nums.length];
        for(int i=0;i<in.length;i++){
            in[i]=false;
        }
        backtrace(res, new LinkedList<>(), 0, in, nums);
        return res;
    }
    private void backtrace(List l, List add, int i, boolean[] in, int[] nums){
        if(i==nums.length){
            l.add(add);
        }else{
            for(int j=0;j<in.length;j++){
                if(!in[j]){
                    boolean[] in2=new boolean[in.length];
                    for(int k=0;k<in2.length;k++){
                        if(k==j) in2[k]=true;
                        else in2[k]=in[k];
                    }
                    List add2=new LinkedList<>();
                    add2.addAll(add);
                    add2.add(nums[j]);
                    backtrace(l, add2, i+1, in2, nums);
                }
            }
        }
    }
    public static void main(String[] args){
        System.out.println("permutations");
        //testParaPassArray();
        test();
    }
    public static void test(){
        int[] nums={1,2,3};
        System.out.println(new Solution().permute(nums));
    }
    private static void testParaPassArray(){
        int[] arr={1,2,3};
        passArray(arr);
        for(int i: arr) System.out.print(i+" ");
        System.out.println("");
    }
    private static void passArray(int[] arr){
        arr[0]=-arr[0];
        for(int i: arr) System.out.print(i+" ");
        System.out.println("");
    }
}