import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //normal solution overtime
    public String minWindow(String s, String t) {
        int lengthS=s.length(), lengthT=t.length();
        if(lengthS==0||lengthT==0) return "";
        if(lengthS<lengthT) return "";
        int[] res=new int[2];res[1]=lengthS;
        int left=0,right=0;
        HashMap set=new HashMap<>(), temp=new HashMap<>();
        for(int i=0;i<lengthT;i++) set.put(t.charAt(i),(int)set.getOrDefault(t.charAt(i), 0)+1);
        boolean flag=false;
        while(left<=lengthS-lengthT){
            right=left;
            temp=(HashMap)set.clone();
            while(right<lengthS){
                if(temp.containsKey(s.charAt(right))){
                    int value=(int)temp.get(s.charAt(right));
                    if(value==1) temp.remove(s.charAt(right));
                    else temp.put(s.charAt(right), value-1);
                }
                right++;
                if(temp.isEmpty()){
                    flag=true;
                    if(right-left<res[1]-res[0]){
                        res[0]=left;
                        res[1]=right;
                    }
                    break;
                }
            }
            if(!temp.isEmpty()&&!flag) return "";
            left++;
        }
        return s.substring(res[0],res[1]);
    }
    public static void main(String[] args){
        System.out.println("minimum window substring");
        test();
    }
    private static void test(){
        //System.out.println(new Solution().minWindow("ADOBECODEBANC","ABC"));
        System.out.println(new Solution().minWindow("a","b"));
    }
}