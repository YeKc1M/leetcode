import java.util.Arrays;

public class NextPermutation{
    public void nextPermutation(int[] nums) {
        int maxIndex=nums.length-1;
        int minMaxIndex=maxIndex;
        int minIndex=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[maxIndex]){
                minIndex=i;
                for(int j=minIndex+1;j<nums.length;j++){
                    if(nums[j]>nums[minIndex]&&nums[minMaxIndex]>nums[j]){
                        minMaxIndex=j;
                    }
                }
                break;
            }else{
                maxIndex=i;
                minMaxIndex=i;
            }
        }
        if(minIndex==-1){
            Arrays.sort(nums);
        }else{
            int temp=nums[minMaxIndex];
            nums[minMaxIndex]=nums[minIndex];
            nums[minIndex]=temp;
            int[] arr=Arrays.copyOfRange(nums, minIndex+1, nums.length);
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                nums[maxIndex+i]=arr[i];
            }
        }
    }
    public static void main(String[] args){
        System.out.println("hello world!");
        int[] arr={2,3,1};
        new NextPermutation().nextPermutation(arr);
    }
}