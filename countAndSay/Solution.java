public class Solution {
    //normal solution 7%-5%
    public String countAndSay(int n) {
        String s="1",temp=new String("");
        for(int i=0;i<n-1;i++){
            if(s.length()==1){
                temp+=("1"+s);
                s=temp;
                temp="";
            }else{
                int count=1;
                int j=0;
                for(;j<s.length()-1;j++){
                    if(s.charAt(j)==s.charAt(j+1)){
                        count++;
                    }else{
                        temp+=(count+""+s.charAt(j));
                        count=1;
                    }
                }
                if(s.charAt(j)==s.charAt(j-1)){
                    temp+=(count+""+s.charAt(j));
                }else{
                    temp+=("1"+s.charAt(j));
                }
                s=temp;
                temp="";
            }
        }
        return s;
    }
    public static void main(String[] args){
        System.out.println("count and say");
        //pass
        //for(int i=1;i<6;i++) test(i);
    }
    public static void test(int n){
        System.out.println(new Solution().countAndSay(n));
    }
}