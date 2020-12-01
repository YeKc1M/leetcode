package recognizestring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
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
    //leetcode solution
    public String reorganizeString1(String S) {
        StringBuilder builder = new StringBuilder();
        int[] count = new int[26];
        int maxCount = 0;
        for(int i=0; i<S.length(); i++){
            count[S.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, count[S.charAt(i) - 'a']);
        }
        if(maxCount > (S.length() + 1)/2){
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>(){

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return count[o2 - 'a'] - count[o1 - 'a'];
			}
        });
        for(int i=0; i<count.length; i++){
            if(count[i] != 0){
                queue.offer((char)(i + 'a'));
            }
        }
        do{
            char max1 = queue.poll(), max2 = queue.poll();
            builder.append(max1); builder.append(max2);
            if(--count[max1 - 'a'] > 0){
                queue.offer(max1);
            }
            if(--count[max2 - 'a'] > 0){
                queue.offer(max2);
            }
        }while(queue.size() > 1);
        if(queue.size() > 0){
            builder.append(queue.poll());
        }
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(new Solution()
        .reorganizeString("uvpzvvfvadaunvbcrwuvvvkvvocvvvvvvvvvcvccvvvvvlvvvivmdvvvvyvvgvxvvbeylvvvvxvvavvtbinvvbsevzvlvyxlvvfvtvvierumdwkvvvvvyvvvylkpvovwvwcvcvmtvjlvygkvhvyvvvkfvmbvxpiyjvvrvvjvfvvvnvvvvgdevvinvvyqvqvmvvkavydvkvviekpvvvwtbvvvhvkuvvkvvcvvjvvvqzvzvavvvosvvtevdgvvqvvvvvjeqvsxpvvzjvkvvvvkkxzvqvvvvvvvvxpvvefvvvsukdovivotvxlrsovzvdpmiqvvvvgunvvuvpavvvoafuvahpvfvacvvvdvivvluvwxaapvuvvktuvvvvdvvvvgvvvvkhvvvdpvsrvwvvlvvvvoevzhvmkvvvozvvvmvdmvvvyvopekvvyfvqkpvvfhgvvivdvvavvvmvmvvvvmqhevkpirxivvqvvvhjvnvxvcvvvgxvj"));
    }
}