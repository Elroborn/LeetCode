public class sorts{
    public static void merge_sort(int[]nums){
        int[] tmp = new int[nums.length];
        merge_sort_helper(nums, tmp, 0, nums.length-1);
    }
    public static void merge_sort_helper(int[]nums,int[] tmp,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (left+right) /2;
        merge_sort_helper(nums,tmp,left,mid);
        merge_sort_helper(nums,tmp,mid+1,right);
        int i = left,j = mid+1,index = left;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                tmp[index++] = nums[i++];
            }else{
                tmp[index++] = nums[j++];
            }
        }
        while(i<=mid){
            tmp[index++] = nums[i++];
        }
        while(j<=right){
            tmp[index++] = nums[j++];
        }
        for(i=left;i<=right;i++){
            nums[i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,1,5,6};
        merge_sort(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }

}