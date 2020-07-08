import java.util.Arrays;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-08 15:31:47
 * @FilePath: \leetcode\455_分发饼干\Solution.java
 * @LastEditTime: 2020-07-08 15:53:46
 */ 
class Solution {
    public int findContentChildren(int[] g, int[] s) {
    
        // 先给胃口小的孩子分
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0,si = 0;
        while(gi<g.length && si<s.length){
            if(g[gi]<=s[si]){
                gi++; //饼干给他
                // si++;
            }
            // else{
            //     // si++;
            // }
            si++; // 其实包含了两层意思，如果饼干可以的话，给他 既放在if里面，还有一层是饼干不行，那么继续找，放在else里面，这里合起来了
        }
        return gi;
    }

 
}