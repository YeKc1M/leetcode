package foursumii;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class foursumii {
    public static void main(String[] args){
        System.out.println("x");
        Solution.main(args);
    }
}
//https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
class Solution {
    //my solution.
    //time over
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int i=0; i<B.length; i++){
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                int mapkey = iterator.next();
                int key = mapkey + B[i];
                int mapvalue = map.get(mapkey);
                int value = temp.getOrDefault(key, 0);
                temp.put(key, value + mapvalue);
            }
        }
        map = temp;
        temp = new HashMap<>();
        for(int i=0; i<C.length; i++){
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                int mapkey = iterator.next();
                int key = mapkey + C[i];
                int mapvalue = map.get(mapkey);
                int value = temp.getOrDefault(key, 0);
                temp.put(key, value + mapvalue);
            }
        }
        map = temp;
        temp = new HashMap<>();
        for(int i=0; i<D.length; i++){
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext()){
                int mapkey = iterator.next();
                int key = mapkey + D[i];
                int mapvalue = map.get(mapkey);
                int value = temp.getOrDefault(key, 0);
                temp.put(key, value + mapvalue);
            }
        }
        map = temp;
        temp = null;
        return map.getOrDefault(0, 0);
    }

    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        //HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int key = A[i] + B[j];
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int key = C[i] + D[j];
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }
        Iterator<Integer> iterator1 = map1.keySet().iterator();
        int count = 0;
        while(iterator1.hasNext()){
            int key = iterator1.next();
            count += map2.getOrDefault(-key, 0) * map1.get(key);
        }
        return count;
    }

    /*
    作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        System.out.println(new Solution()
        .fourSumCount(A, B, C, D));
    }
}