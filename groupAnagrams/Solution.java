package groupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    //normal solution timeout
    public List<List<String>> groupAnagrams(String[] strs) {
        List res=new LinkedList<>();
        List mapList=new LinkedList<>();
        HashMap holder;
        for(int i=0;i<strs.length;i++){
            holder=new HashMap<>();
            for(int j=0;j<strs[i].length();j++){
                holder.put(strs[i].charAt(j), (int)holder.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            int index=-1;
            for(int j=0;j<mapList.size();j++){
                if(mapList.get(j).equals(holder)){
                    index=j;
                    break;
                }
            }
            if(index==-1){
                mapList.add(holder);
                List newList=new LinkedList<>();
                newList.add(strs[i]);
                res.add(newList);
            }else{
                List l=(List)res.get(index);
                l.add(strs[i]);
            }
        }
        return res;
    }
    //43% 95%
    public List<List<String>> groupAnagrams1(String[] strs){
        Map map=new HashMap<>();
        for(String str: strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(map.containsKey(key)){
                List l=(List)map.get(key);
                l.add(str);
            }else{
                List l=new LinkedList<>();
                l.add(str);
                map.put(key, l);
            }
        }
        return new LinkedList(map.values());
    }
    public static void main(String[] args){
        System.out.println("group anagrams");
        //testSetEquals();
        //testMapEquals();
        //test();
        test1();
    }
    private static void test(){
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
    private static void test1(){
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams1(strs));
    }
    public static void testMapEquals(){
        HashMap m1=new HashMap<>(),m2=new HashMap<>();
        m1.put('a', 1);m1.put('c', 2);m1.put('d', 4);
        m2.put('d', 4);m2.put('c', 2);m2.put('a', 1);
        System.out.println(m1.equals(m2));
    }
}