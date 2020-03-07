public class Solution {
    public boolean isPalindrome(String s) {
        String str=format(s);
        int index1=0, index2=str.length()-1;
        while(index1<=index2){
            if(str.charAt(index1++)==str.charAt(index2--)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    private String format(String s){
        return s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
    }
    public static void main(String[] args){
        System.out.println("valid palindrome");
        new Solution().isPalindrome("0P");
    }
    public static void re(){
        String str="a man, a can, a Bin. can bin";
        str=str.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
        System.out.println(str);
    }
}