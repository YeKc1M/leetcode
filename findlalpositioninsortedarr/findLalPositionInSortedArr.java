package findlalpositioninsortedarr;

public class findLalPositionInSortedArr {
    //
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int l = 0, r = nums.length;
        while(l < r){
            int medium = (l + r) / 2;
            if(nums[medium] == target){
                for(int i=medium; i>=l && nums[i]==target; i--){
                    res[0] = i;
                }
                for(int i=medium; i<r && nums[i]==target; i++){
                    res[1] = i;
                }
                break;
            }else if(nums[medium] > target){
                for(int i=medium; i>=l && nums[i]==nums[medium]; i--){
                    r = i;
                }
            }else{
                for(int i=medium; i<=r && nums[i]==nums[medium]; i++){
                    l = i;
                }
            }
        }
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res={-1, -1};
        int medium=binarysearch(nums, target);
        if(medium!=-1){
            int i;
            for(i=medium;i>0&&nums[i]==nums[i-1];i--);
            res[0]=i;
            for(i=medium;i<nums.length-1&&nums[i]==nums[i+1];i++);
            res[1]=i;
        }
        return res;
    }
    public int binarysearch(int[] nums, int target){
        int left=0, right=nums.length, medium=(left+right)/2;
        while(left<=medium&&medium<right){
            if(nums[medium]==target) return medium;
            else if(target<nums[medium]){
                right=medium;
                medium=(left+right)/2;
            }else{
                left=medium+1;
                medium=(left+right)/2;
            }
        }
        return -1;
    }
}

