package recognizestring;

import java.util.Arrays;

public class RecognizeString {
    public static void main(String[] args){
        System.out.println("x");
    }
}

//https://leetcode-cn.com/problems/reorganize-string/

class Solution {
    public String reorganizeString(String S) {
        if(S.length()<=1) return S;

        int[] count = new int[26];
        StringBuilder builder = new StringBuilder(S);
        for(int i=0; i<builder.length(); i++){
            count[(int)builder.charAt(i) - (int)'a']++;
        }
        int maxIndex = 0;
        for(int i=1; i<count.length; i++){
            if(count[i] > count[maxIndex]){
                maxIndex = i;
            }
        }

        char maxChar = (char)(maxIndex + (int)'a');
        int maxCharIndex = 0;
        for(; maxCharIndex < builder.length() && maxChar != builder.charAt(maxCharIndex); maxCharIndex++);
        //char firstTemp = builder.charAt(0);
        builder.replace(maxCharIndex, maxCharIndex + 1, builder.charAt(0) + "");
        builder.replace(0, 1, maxChar + "");

        int l = 0, r = 0;
        while(l < builder.length() - 1){
            char lchar = builder.charAt(l);
            r = l + 1;
            if(lchar == builder.charAt(r)){
                do{
                    r++;
                }while(r != builder.length() && lchar == builder.charAt(r));
                if(r == builder.length()){
                    return "";
                }else{
                    char temp = builder.charAt(l + 1);
                    builder.replace(l + 1, l + 2, builder.charAt(r) + "");
                    builder.replace(r, r + 1, temp + "");
                }
            }
            l++;
        }
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(new Solution()
        .reorganizeString("blflxll"));
    }
}