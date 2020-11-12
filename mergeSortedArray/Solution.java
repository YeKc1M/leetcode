package mergeSortedArray;

public class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
        // compare two elements from nums1 and nums2 
        // and add the largest one in nums1 
        nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
    //normal solution 5%-5%
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int index1=0,index2=0;
        if(n==0) return;
        if(m==0){
            for(int i=0;i<n;i++) nums1[i]=nums2[i];
            return;
        }
        while(index1<m){
            if(nums1[index1]<=nums2[index2]){
                index1++;
            }else{
                int temp=nums1[index1];
                nums1[index1]=nums2[index2];
                nums2[index2]=temp;
                index1++;
                if(nums2[index2]>nums2[(index2+1)%n]){
                    for(int i=0;i<n-1;i++){
                        if(nums2[i]>nums2[i+1]){
                            int temp2=nums2[i];
                            nums2[i]=nums2[i+1];
                            nums2[i+1]=temp2;
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[(index2+i)%n];
        }
        return;
    }
    public static void main(String[] args){
        System.out.println("merge sorted array");
        test();
    }
    private static void test(){
        int[] nums1={4,0,0,0,0,0};
        int[] nums2={1,2,3,5,6};
        Solution s=new Solution();
        s.merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
    }
}