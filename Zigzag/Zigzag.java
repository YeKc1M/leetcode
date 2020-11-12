package Zigzag;

public class Zigzag {
    public String convert(String s, int numRows) {
        String res="";
        int length=s.length();
        if(numRows==1) return s;
        String[] strs=new String[numRows];
        for(int i=0;i<numRows;i++) strs[i]=new String();
        for(int i=0;i<length;i++){
            int j=i/(numRows-1);
            int k=i%(numRows-1);
            if(j%2==0){
                strs[k]+=s.charAt(i);
            }else{
                strs[numRows-k-1]+=s.charAt(i);
            }
        }
        for(int i=0;i<numRows;i++) res+=strs[i];
        return res;
    }
    public static void main(String[] args){
        System.out.println("hello world!");
    }
}