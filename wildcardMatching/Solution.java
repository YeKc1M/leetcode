public class Solution {
    //normal solution timeout
    public boolean isMatch(String s, String p) {
        int indexS=0, indexP=0;
        boolean res=true;
        while(indexS<s.length()&&indexP<p.length()){
            if(p.charAt(indexP)=='?'){
                indexS++;indexP++;
            }else if(p.charAt(indexP)=='*'){
                //star match
                res=isMatch(s.substring(indexS), p.substring(indexP+1, p.length()))||
                    isMatch(s.substring(indexS+1, s.length()), p.substring(indexP));
                return res;
            }else{
                if(p.charAt(indexP)==s.charAt(indexS)){
                    indexS++;
                    indexP++;
                }else{
                    return false;
                }
            }
        }
        if(indexS==s.length()){
            if(indexP==p.length()) return true;
            else{
                for(int i=p.length()-1;i>=indexP;i--){
                    if(p.charAt(i)!='*') return false;
                }
                return true;
            }
        }else return false;
    }
    public static void main(String[] args){
        System.out.println("wildcard matching");
        test();
    }
    public static void test(){
        Solution s=new Solution();
        System.out.println(s.isMatch("ho", "*ho**"));
    }
}