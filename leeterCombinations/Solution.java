import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //normal solution. combine the first 'n-1'-digit-combination and the last-digit-combination
    public List<String> letterCombinations(String digits){
        if(digits.equals("")){
            return new LinkedList<>();
        }
        List res=null;
		List temp=new LinkedList<>();
		List holder=null;
        for(int i=0;i<digits.length();i++){
            holder=numToLetters(digits.charAt(i));
            if(holder!=null){
                if(res==null){
                    res=holder;
                }else{
                    Iterator holdItr=holder.iterator();
                    while(holdItr.hasNext()){
                        Iterator resItr=res.iterator();
                        String h=(String)holdItr.next();
                        while(resItr.hasNext()){
                            String r=(String)resItr.next();
                            String s=r+h;
                            temp.add(s);
                        }
                    }
                    res=temp;
                    temp=new LinkedList<>();
                }
            }
        }
        return res;
    }
    //backtracing
    public List<String> letterCombinations1(String digits){
        List l=new LinkedList<>();
        if(digits.length()!=0){
            backtrack(l, "", digits);
        }
        return l;
    }
    //backtracing
    private void backtrack(List l, String combination, String digits){
        if(digits.length()==0){
            l.add(combination);
        }else{
            List nexts=numToLetters(digits.charAt(0));
            Iterator itr=nexts.iterator();
            while(itr.hasNext()){
                backtrack(l, combination+(String)itr.next(), digits.substring(1, digits.length()));
            }
        }
    }
    public static List<String> numToLetters(char num){
        List l=new LinkedList<>();
        switch(num){
            case '2':
                l.add("a");l.add("b");l.add("c");
                break;
            case '3':
                l.add("d");l.add("e");l.add("f");
                break;
            case '4':
                l.add("g");l.add("h");l.add("i");
                break;
            case '5':
                l.add("j");l.add("k");l.add("l");
                break;
            case '6':
                l.add("m");l.add("n");l.add("o");
                break;
            case '7':
                l.add("p");l.add("q");l.add("r");l.add("s");
                break;
            case '8':
                l.add("t");l.add("u");l.add("v");
                break;
            case '9':
                l.add("w");l.add("x");l.add("y");l.add("z");
                break;
            default:
                return null;
        }
        return l;
    }
    public static void main(final String[] args){
        System.out.println("letter combinations.");
        test();
    }
    public static void test(){
        System.out.println(new Solution().letterCombinations(""));
    }
}