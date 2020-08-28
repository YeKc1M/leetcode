import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List res=new LinkedList<>();
        List current=new LinkedList<>();
        backtrace(res, current, candidates, target);
        return res;
    }
    private void backtrace(List res, List current, int[] candidates, int target){
        if(target==0){
            List temp=new LinkedList<>(current);
            res.add(temp);
        }else if(target>0){
            for(int i=0;i<candidates.length;i++){
                current.add(candidates[i]);
                backtrace(res, current, Arrays.copyOfRange(candidates, i, candidates.length), target-candidates[i]);
                current.remove(current.size()-1);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("hello world!");
    }
}