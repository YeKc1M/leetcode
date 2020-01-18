//container-with-most-water
public class Solution{
    public int maxArea(int[] height){//normal solution
        int max=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int temp=(j-i)*Math.min(height[i], height[j]);
                if(temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }
    public int maxArea1(int[] height){//double pointer
        int max=0,l=0,r=height.length-1;
        while(l<r){
            max=Math.max(max, Math.min(height[l], height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    public static void main(String[] args){
        //System.out.println("hello world!");
        //test1();
        test2();
    }
    public static void test1(){
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
    public static void test2(){
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea1(height));
    }
}