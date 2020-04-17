#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int left = 0,right = 0;
        int min_size = nums.size()+1;
        int sum = 0;
        for(right=0;right<nums.size();right++){
            sum+=nums[right];
            while (sum>=s)
            {
                min_size = min(min_size,right-left+1);
                sum-=nums[left++];
            }
        }
        return min_size== nums.size()+1?0:min_size;

    }
};
int main(){
     vector<int> nums = {2,3,1,2,4,3};
     cout<<Solution().minSubArrayLen(7,nums);
    return 0;
}