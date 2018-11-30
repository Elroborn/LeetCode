'''
Created on 2018年11月20日

@author: coderwangson
'''
"#codeing=utf-8"
class Solution():
    def twoSum(self, nums, target):
        d = {}
        for i, v in enumerate(nums):
            if v in d:
                return [d[v], i]
            d[target - v] = i

if __name__ == '__main__':
    print(Solution().twoSum([2, 7, 11, 15], 22))
#     assert Solution().twoSum([2, 7, 11, 15], 22) == [1, 3]
