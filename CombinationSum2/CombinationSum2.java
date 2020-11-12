package CombinationSum2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List res=new LinkedList<>();
        List current=new LinkedList<>();
        backtrace(candidates, target, current, res, 0);
        return res;
    }
    private void backtrace(int[] candidates, int target, List current, List res, int level){
        if(target==0){
            Object[] arr=current.toArray();
            Arrays.sort(arr);
            List temp=Arrays.asList(arr);
            if(!res.contains(temp)){
                res.add(temp);
            }
        }else if(target>0){
            if(level==candidates.length) return;
            backtrace(candidates, target, current, res, level+1);
            if(candidates[level]<=target){
                current.add(candidates[level]);
                backtrace(candidates, target-candidates[level], current, res, level+1);
                current.remove(current.size()-1);
            }
        }
    }
    public static void main(String[] args){
        CombinationSum2 solution=new CombinationSum2();
        int[] arr={10,1,2,7,6,1,5};
        int target=8;
        solution.combinationSum2(arr, target);
    }
}