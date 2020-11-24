package relativesortarray;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    //my solution
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i], 0);
        }
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                int value=map.get(arr1[i]);
                map.put(arr1[i], value+1);
            }else{
                list.add(arr1[i]);
            }
        }
        Collections.sort(list);
        int[] ans=new int[arr1.length];
        int index=0;
        for(int i=0;i<arr2.length;i++){
            int count=map.get(arr2[i]);
            for(int j=0;j<count;j++){
                ans[index++]=arr2[i];
            }
        }
        Iterator<Integer> itr=list.iterator();
        while(itr.hasNext()){
            ans[index++]=itr.next();
        }
        return ans;
    }
    //my solution II
    public int[] relativeSortArray_II(int[] arr1, int[] arr2){
        int ans[]=new int[arr1.length];
        List<Integer> list=new LinkedList<>();
        for(int i: arr1) list.add(i);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i], i);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(map.containsKey(a)){
                    if(map.containsKey(b)){
                        return map.get(a)-map.get(b);
                    }else{
                        return -1;
                    }
                }else{
                    if(map.containsKey(b)){
                        return 1;
                    }else{
                        return a-b;
                    }
                }
            }
        });
        Iterator<Integer> itr=list.iterator();
        for(int i=0;i<ans.length;i++){
            ans[i]=itr.next();
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println("hello world!");
    }
}