import java.util.Arrays;
import java.util.Stack;

public class Solution {
    //normal solution 32%-46%
    public int trap(int[] height) {
        if(height.length<=2) return 0;
        int area=0;
        int s=0;
        for(;s<height.length-1;s++){
            if(height[s]>height[s+1]){
                break;
            }
        }
        if(s>=height.length-2) return 0;
        Stack stack=new Stack<>();stack.push(s);
        for(int i=s+1;i<height.length;i++){
            int last=height[(int)stack.peek()];
            if(height[i]>last){
                //count u-shape area
                do{
                    int bottomIndex=(int)stack.pop();
                    if(stack.isEmpty()) break;
                    int depth=Math.min(height[i], height[(int)stack.peek()])-height[bottomIndex];
                    area=area+depth*(i-1-(int)stack.peek());
                }while(height[i]>height[(int)stack.peek()]);
            }
            stack.push(i);
        }
        return area;
    }
    public static void main(String[] args){
        System.out.println("trapping rain water");
        //test();
    }
    public static void test(){
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));
    }
}