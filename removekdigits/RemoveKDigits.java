public class RemoveKDigits {
    public static void main(String[] args){
        System.out.println("hello world!");
        System.out.println(new RemoveKDigits()
            .removeKdigits("112", 1));
    }

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
}