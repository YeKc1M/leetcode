import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        String longest=new String(s.charAt(0)+"");
        HashMap hashmap=new HashMap<Character,Set>();
        for(int i=0;i<s.length();i++){
            if(hashmap.get(s.charAt(i))==null){
                Set set=new HashSet<Integer>();
                set.add(i);
                hashmap.put(s.charAt(i),set);
            }else{
                Set set=(Set)hashmap.get(s.charAt(i));
                Iterator itr=set.iterator();
                while(itr.hasNext()){
                    int j=(int)itr.next();
                    if(i-j+1<longest.length()){
                        continue;
                    }
                    boolean b=true;
                    for(int k=1;k<=(i-j)/2;k++){
                        Set s1=(Set)hashmap.get(s.charAt(i-k));
                        if(s1.contains(j+k)&&s1.contains(i-k)){
                            continue;
                        }else{
                            b=false;
                            break;
                        }
                    }
                    if(b){
                        longest=s.substring(j,i+1);
                    }
                }
                set.add(i);
            }
        }
        return longest;
    }
    public static void main(String[] args){
        System.out.println(new Solution().longestPalindrome("abcda"));
    }
}