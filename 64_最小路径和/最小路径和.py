"""
Created on 2019/5/17 15:40
@File:最小路径和.py
@author: coderwangson
"""
"#codeing=utf-8"

import copy
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dfs = [[0]*len(grid[0]) for _ in range(len(grid))]
        dfs[0][0] = grid[0][0]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i==0 and j==0: dfs[i][j] = grid[i][j]
                elif j==0: dfs[i][j] = grid[i][j] + dfs[i-1][j]
                elif i==0: dfs[i][j] = grid[i][j] + dfs[i][j-1]
                else: dfs[i][j] = grid[i][j] + min(dfs[i-1][j],dfs[i][j-1])

        return dfs[i][j]


print(Solution().minPathSum([
  [1,3,1],
  [1,5,1],
  [4,2,1]
]))