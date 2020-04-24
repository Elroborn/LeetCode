class Solution {
    public int reversePairs1(int[] nums) {
        int res = 0;
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    res++;
                }
            }
        }
        return res;
    }


    public int reversePairs(int[] nums) {
        int tmp[] = new int[nums.length];
        return merge_sort(0, nums.length-1, nums, tmp);
    }
    public int merge_sort(int left,int right,int[] nums,int[]tmp){
        if(left>=right){
            return 0;
        }
        int mid = (left+right)/2;
        int left_cnt = merge_sort(left, mid, nums, tmp);
        int right_cnt = merge_sort(mid+1, right, nums, tmp);
        int i = mid,j = right,index = right;
        int cnt = 0;
        while(i>=left && j>mid){ //注意这里是从右到左，因为这样才能判断出逆序对，平时的归并是从左到右
            if(nums[i]>nums[j]){ //逆序 因为nums[mid]-nums[j]是有序从小到大，而nums[i]>nums[j] 则说明大于整个区间，即全部逆序
                cnt+=(j-mid); // j-(mid+1) +1
                tmp[index--] = nums[i--];
            }else{
                tmp[index--] = nums[j--];
            }
        }
        while(i>=left){
            tmp[index--] = nums[i--];
        }
        while(j>mid){
            tmp[index--] = nums[j--];
        }
        for(int k=left;k<=right;k++){
            nums[k] = tmp[k];
        }
        return (left_cnt+right_cnt+cnt);
    }
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(new Solution().reversePairs(nums));
        for(int i:nums){
            System.out.println(i);
        }
    }
}