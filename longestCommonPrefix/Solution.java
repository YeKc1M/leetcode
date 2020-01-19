public class Solution{
    public String longestCommonPrefix(String[] strs){//normal solution
        if(strs.length==0){
            return "";
        }
        String res="";
        int index=-1;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            max=Math.min(max, strs[i].length());
        }
        for(int i=0;i<max;i++){
            char current=strs[0].charAt(i);
            boolean equal=true;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)==current){
                    continue;
                }else{
                    equal=false;
                    break;
                }
            }
            if(equal){
                index=i;
            }else{
                break;
            }
        }
        res=strs[0].substring(0,index+1);
        return res;
    }
    public static void main(String[] args){
        test1();
    }
    public static void test1(){
        String[] strs={};
        String p=new Solution().longestCommonPrefix(strs);
        System.out.println(p);
    }
}