/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-05 11:07:42
 * @FilePath: \leetcode\剑指 Offer 05. 替换空格\Solution.java
 * @LastEditTime: 2020-10-05 11:09:44
 */
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}