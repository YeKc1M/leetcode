package sortarraybyparityii;

public class SortArrayByParityII {
    public static void main(String[] args){
        System.out.println("hello world!");
        Solution.test();
    }
}
/*
922.按奇偶排序数组
给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /*
    my solution
     */
    public int[] sortArrayByParityII(int[] A) {
        for(int i=0;i<A.length;i++){
            int remainder=i%2;
            if(A[i]%2 != remainder){
                for(int j=i+1;j<A.length;j++){
                    if(A[j]%2==remainder){
                        swapByIndex(A, i, j);
                        break;
                    }
                }
            }
        }
        return A;
    }
    /*
    leetcode solution-1
     */
    public int[] sortArrayByParityII_I(int[] A){
        int[] ans=new int[A.length];
        int evencount=0;
        int oddcount=1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                ans[evencount]=A[i];
                evencount+=2;
            }else{
                ans[oddcount]=A[i];
                oddcount+=2;
            }
        }
        return ans;
    }

    /*
    leetcode solution-2
     */
    public int[] sortArrayByParityII_II(int[] A){
        int evenIndex=0;
        int oddIndex=1;
        while (evenIndex<A.length){
            if(A[evenIndex]%2!=0){
                while (oddIndex<A.length&&A[oddIndex]%2==1){
                    oddIndex+=2;
                }
                swapByIndex(A, evenIndex, oddIndex);
            }else{
                evenIndex+=2;
            }
        }
        return A;
    }

    /*
    swap array element by index
     */
    private void swapByIndex(int[] A, int index1, int index2){
        try {
            if (index1 >= A.length || index2 >= A.length)
                throw new IndexOutOfBoundsException("index1 or index2 out of bound");
            int temp = A[index1];
            A[index1] = A[index2];
            A[index2] = temp;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void test(){
        int[] arr={4,2,5,7};
        Solution s=new Solution();
        arr=s.sortArrayByParityII(arr);
        for(int i: arr) System.out.print(i+" ");
    }
}
