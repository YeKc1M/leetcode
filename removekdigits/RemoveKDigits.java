package removekdigits;

public class RemoveKDigits {
    public static void main(String[] args){
        System.out.println("hello world!");
        System.out.println(new RemoveKDigits()
            .removeKdigits("112", 1));
        System.out.println(new RemoveKDigits()
        .removeKDigits_II("5337", 2));
    }
    /*
     * my solution 1: remove one by one
    */
    public String removeKdigits(String num, int k) {
        StringBuilder builder=new StringBuilder(removeOneDigit(num, 0, k));
        return builder.toString();
    }
    private String removeOneDigit(String num, int depth, int k){
        if(depth==k) return num;
        if(num.length()==1) return "0";
        StringBuilder builder=new StringBuilder(num);
        for(int i=0;i<builder.length();i++){
            if(i<builder.length()-1&&builder.charAt(i)>builder.charAt(i+1)){
                builder.replace(i, i+1, "");
                break;
            }else if(i==builder.length()-1){
                builder.replace(i, i+1, "");
                break;
            }
        }
        while(builder.length()!=1&&builder.charAt(0)=='0'){
            builder.replace(0, 1, "");
        }
        return removeOneDigit(builder.toString(), depth+1, k);
    }
    /*
     * my solution 2
     */
    public String removeKDigits_II(String num, int k){
        if(num.length()<=k) return "0";
        StringBuilder builder=new StringBuilder();
        int count=0;
        int index=1;
        builder.append(num.charAt(0));
        char current;
        while(count<k&&index<num.length()){
            current=num.charAt(index++);
            if(builder.charAt(builder.length()-1)>current){
                do{
                    builder.deleteCharAt(builder.length()-1);
                    count++;
                }while(count<k&&
                builder.length()>0&&
                builder.charAt(builder.length()-1)>current);
            }
            builder.append(current);
        }
        while(count<k){
            builder.deleteCharAt(builder.length()-1);
            count++;
        }
        while(index<num.length()){
            for(;index<num.length();index++){
                builder.append(num.charAt(index));
            }
        }
        while(builder.length()>1&&builder.charAt(0)=='0'){
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}