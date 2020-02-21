public class Solution {
    //normal solution memory out
    public int largestRectangleArea(int[] heights){
        int n=heights.length;
        int[][] min=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=i;
                for(int k=i;k<=j;k++){
                    if(heights[k]<heights[temp]){
                        temp=k;
                    }
                }
                min[i][j]=temp;
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                res=Math.max(res, (j-i+1)*heights[min[i][j]]);
            }
        }
        return res;
    }
    //wrong solution
    public int largestRectangleArea1(int[] heights){
        int n=heights.length;
        int[][] min=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=i;
                for(int k=i;k<=j;k++){
                    if(heights[k]<heights[temp]){
                        temp=k;
                    }
                }
                min[i][j]=temp;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                int temp=i;
                for(int k=i;k>=j;k--){
                    if(heights[k]<heights[temp]){
                        temp=k;
                    }
                }
                min[i][j]=temp;
            }
        }
        int l=0,r=n-1;
        int res=0;
        while(l<=r){
            int temp=(r-l+1)*heights[min[l][r]];
            if(temp>res) res=temp;
            if(heights[l]<heights[r]){
                l=min[l][r]+1;
            }else if(heights[l]>heights[r]){
                r=min[r][l]-1;
            }else{
                int l2r=min[l][r]-l;
                int r2l=r-min[r][l];
                if(l2r<r2l){
                    l=min[l][r]+1;
                }else{
                    r=min[r][l]-1;
                }
            }
        }
        return res;
    }
    //divide and conquer
    public int largestRectangleArea2(int[] heights){
        return calculate(heights, 0, heights.length-1);
    }
    private int calculate(int[] height, int start, int end){
        if(start>end) return 0;
        int minIndex=start;
        for(int i=start;i<=end;i++){
            if(height[i]<height[minIndex]) minIndex=i;
        }
        return Math.max((start-end+1)*height[minIndex], Math.max(calculate(height, minIndex+1, end), calculate(height, start, minIndex-1)));
    }
    public static void main(String[] args){
        System.out.println("largest rectangle in histogram");
        test();
    }
    private static void test(){
        int[] heights={5,5,1,7,1,1,5,2,7,6};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}