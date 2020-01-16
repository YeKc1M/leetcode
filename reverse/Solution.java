public class Solution{
    public int reverse(int x){
        int r=0;
        boolean isPositive;
        if(x>0){
            isPositive=true;
        }else{
            isPositive=false;
        }
        int i=0;
        while(x!=0){
            i=Math.abs(x%10);
            if(isPositive&&((Integer.MAX_VALUE-i)/10<r)){
                return 0;
            }
            if(!isPositive&&(Integer.MIN_VALUE+i)/10>-r){
                return 0;
            }
            r*=10;
            r+=i;
            x/=10;
        }
        return isPositive?r: -r;
    }
    public static void testMaxInt(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    public static void main(String[] args){
        System.out.println(new Solution().reverse(-10));
        //testMaxInt();
    }
}