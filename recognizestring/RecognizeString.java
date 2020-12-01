package recognizestring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class RecognizeString {
    public static void main(String[] args){
        System.out.println("x");
    }
}

//https://leetcode-cn.com/problems/reorganize-string/

class Solution {
    //my solution
    public String reorganizeString(String S) {
        StringBuilder builder = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<S.length(); i++){
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        Object[] entryArr = map.entrySet().toArray();
        if(entryArr.length == 1 && (int)((Entry)entryArr[0]).getValue() > 1) return "";
        Arrays.sort(entryArr, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                Entry entry1 = (Entry)o1, entry2 = (Entry)o2;
                return (int)entry2.getValue() - (int)entry1.getValue();
            }
        });

        int l = 0, r = 1;
        while(r < entryArr.length - 1 && (int)((Entry)entryArr[r + 1]).getValue() == (int)((Entry)entryArr[r]).getValue()){
            r++;
        }
        do{
            Entry lentry = (Entry)entryArr[l], rentry = (Entry)entryArr[r];
            builder.append(lentry.getKey());
            builder.append(rentry.getKey());
            lentry.setValue((int)lentry.getValue() - 1);
            rentry.setValue((int)rentry.getValue() - 1);
            //move l
            if((int)lentry.getValue() < (int)((Entry)entryArr[l + 1]).getValue()){
                l++;
                if(l == r){
                    r++;
                }
            }else if((l > 0) && 
                (int)lentry.getValue() == (int)((Entry)entryArr[l - 1]).getValue()){
                do{
                    l--;
                }while((l > 0) && 
                    (int)lentry.getValue() == (int)((Entry)entryArr[l - 1]).getValue());
            }
            //move r
            if(r > l + 1 && 
                (int)rentry.getValue() < (int)((Entry)entryArr[r - 1]).getValue()){
                r--;
            }else if(r < entryArr.length - 1 && 
                (int)rentry.getValue() == (int)((Entry)entryArr[r + 1]).getValue()){
                do{
                    r++;
                }while(r < entryArr.length - 1 && 
                    (int)((Entry)entryArr[r + 1]).getValue() == (int)((Entry)entryArr[r]).getValue());
            }
        }while(r != entryArr.length - 1 || 
            (int)((Entry)entryArr[r]).getValue() != 0);
        if((int)((Entry)entryArr[l]).getValue() > 1) return "";
        if((int)((Entry)entryArr[l]).getValue() == 1) builder.append(((Entry)entryArr[l]).getKey());
        return builder.toString();
    }
    /* wrong solution
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
    }*/
    public static void main(String[] args){
        System.out.println(new Solution()
        .reorganizeString("uvpzvvfvadaunvbcrwuvvvkvvocvvvvvvvvvcvccvvvvvlvvvivmdvvvvyvvgvxvvbeylvvvvxvvavvtbinvvbsevzvlvyxlvvfvtvvierumdwkvvvvvyvvvylkpvovwvwcvcvmtvjlvygkvhvyvvvkfvmbvxpiyjvvrvvjvfvvvnvvvvgdevvinvvyqvqvmvvkavydvkvviekpvvvwtbvvvhvkuvvkvvcvvjvvvqzvzvavvvosvvtevdgvvqvvvvvjeqvsxpvvzjvkvvvvkkxzvqvvvvvvvvxpvvefvvvsukdovivotvxlrsovzvdpmiqvvvvgunvvuvpavvvoafuvahpvfvacvvvdvivvluvwxaapvuvvktuvvvvdvvvvgvvvvkhvvvdpvsrvwvvlvvvvoevzhvmkvvvozvvvmvdmvvvyvopekvvyfvqkpvvfhgvvivdvvavvvmvmvvvvmqhevkpirxivvqvvvhjvnvxvcvvvgxvj"));
    }
}