package increasingdecreasingstring;

import java.util.Iterator;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/increasing-decreasing-string/
public class Solution {
    public String sortString(String s) {
        StringBuilder builder=new StringBuilder();
        TreeMap<Character, Integer> map=new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(map.containsKey(character)){
                int count = map.get(character);
                map.put(character, count + 1);
            }else{
                map.put(character, 1);
            }
        }
        //System.out.println(map.keySet());
        //System.out.println(map.descendingKeySet());
        while(map.size()!=0){
            //Set<Character> set = map.keySet();
            Iterator<Character> itr = map.keySet().iterator();
            while(itr.hasNext()){
                char c = itr.next();
                builder.append(c);
                int count = map.get(c);
                if(count == 1){
                    itr.remove();
                }else{
                    map.put(c, count - 1);
                }
            }
            //Set<Character> dset = map.descendingKeySet();
            Iterator<Character> ditr = map.descendingKeySet().iterator();
            while(ditr.hasNext()){
                char c = ditr.next();
                builder.append(c);
                int count = map.get(c);
                if(count == 1){
                    ditr.remove();
                }else{
                    map.put(c, count - 1);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        System.out.println("hello world");
        System.out.println(
            new Solution()
            .sortString("rat")
        );
    }
}
