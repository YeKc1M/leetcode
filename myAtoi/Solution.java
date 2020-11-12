package myAtoi;

//regular expression match
public class Solution{
    public int myAtoi(String str){
        if(str.length()==0){
            return 0;
        }
        int atoi=0;
        boolean isPositive=true;
        String s=str;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(s.charAt(i)=='-'||s.charAt(i)=='+'||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                    s=s.substring(i, str.length());
                    break;
                }else{
                    return 0;
                }
            }
        }
        if(s.charAt(0)=='+'){
            s=s.substring(1, s.length());
        }else if(s.charAt(0)=='-'){
            isPositive=false;
            s=s.substring(1,s.length());
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                break;
            }
            int temp=(int)s.charAt(i)-48;
            if(isPositive&&(Integer.MAX_VALUE-temp)/10<atoi){
                return Integer.MAX_VALUE;
            }
            if(!isPositive&&(Integer.MIN_VALUE+temp)/10>-atoi){
                return Integer.MIN_VALUE;
            }
            atoi*=10;
            atoi+=temp;
        }
        return isPositive?atoi: -atoi;
    }
    public static void main(String[] args){
        System.out.println(new Solution().myAtoi("+"));
    }
}