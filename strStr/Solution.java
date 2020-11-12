package strStr;

public class Solution {
    //normal solution
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for(int i=0;i<haystack.length()-needle.length();i++){
            boolean flag=true;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)==needle.charAt(j)){
                    continue;
                }else{
                    flag=false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
    //kmp
    public static void main(String[] args){
        System.out.println("implement strStr");
        //testNav();
        test();
    }
    private static void test(){
        Solution s=new Solution();
        System.out.println(s.strStr("", ""));
    }
}