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
                while(indexP<p.length()-1&&p.charAt(indexP+1)=='*') indexP++;
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
    //dynamic programming 80%-90%
    public boolean isMatch1(String s, String p){
        int sLength=s.length(), pLength=p.length();
        boolean[] b=new boolean[pLength+1];
        b[pLength]=true;
        for(int i=pLength-1;i>=0;i--){
            b[i]= p.charAt(i)=='*'? b[i+1]: false;
        }
        for(int i=sLength-1; i>=0; i--){
            boolean bool=b[pLength];
            for(int j=pLength-1; j>=0; j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
                    boolean temp=b[j];
                    b[j]=bool;
                    bool=temp;
                }else if(p.charAt(j)=='*'){
                    boolean temp=b[j];
                    b[j]=b[j]||b[j+1];
                    bool=temp;
                }else{
                    bool=b[j];
                    b[j]=false;
                }
            }
            b[pLength]=false;
        }
        return b[0];
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