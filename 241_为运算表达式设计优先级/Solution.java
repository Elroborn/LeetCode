import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-26 10:44:56
 * @FilePath: \leetcode\241_为运算表达式设计优先级\Solution.java
 * @LastEditTime: 2020-07-26 11:03:30
 */ 
class Solution {
    private HashMap<String,List<Integer>> memory = new HashMap<>(); // 做备忘录
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input);
    }
    List<Integer> dfs(String input){
        List<Integer> res = new ArrayList<>();
        if(input.length() ==0){ // 递归边界
            res.add(0);
        }
        if(memory.containsKey(input)){
            return memory.get(input);
        }
        boolean flag = true;
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                flag = false;
                for(int left: dfs(input.substring(0, i))){
                    for(int right: dfs(input.substring(i+1, input.length()))){
                        res.add(calc(left,right,c));
                    }
                }
            }
        }
        if(flag){ //里面全部数字 递归边界
            res.add(Integer.parseInt(input));
        }
        memory.put(input, res);
        return res;
    }
    private int calc(int left,int right, char c){
        if(c=='+'){
            return left + right;
        }else if(c=='-'){
            return left - right;
        }else{
            return left * right;
        }
    }
    public static void main(String[] args) {
        String input = "11*6+12";
        for(int i:new Solution().diffWaysToCompute(input)){
            System.out.println(i);
        }
    }
}