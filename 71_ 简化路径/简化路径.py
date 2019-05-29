"""
Created on 2019/5/29 20:12
@File:简化路径.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        path = path.split('/')
        p = [] # 路径栈
        i = 0
        for i in path:
            if i =='.' or i=='': # 同级不管 split后会有空，因为//
                continue
            elif i=='..': # 上一级则弹出
                if len(p) > 0:p.pop()
            else: # 其他则入栈
                p.append(i)
        # 结果开头为 / 如果p里面有东西则用/连起来，没有则为无
        return "/" + "/".join(p)
print(Solution().simplifyPath("/../"))


