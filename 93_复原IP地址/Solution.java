import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-09 10:11:35
 * @FilePath: \leetcode\93_复原IP地址\Solution.java
 * @LastEditTime: 2020-08-09 10:42:55
 */
// https://leetcode-cn.com/problems/restore-ip-addresses/solution/yong-ijkbian-li-zhe-san-ge-xiao-shu-dian-de-wei-zh/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<4){
            return res;
        }
        for(int i = 1;i<s.length() && i<=3;i++){
            for(int j = i+1;j<s.length() && j<=i+3;j++){
                for(int k = j+1;k<s.length() && k<=j+3;k++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());
                    if(check(s1) && check(s2) && check(s3) && check(s4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1);
                        sb.append(".");
                        sb.append(s2);
                        sb.append(".");
                        sb.append(s3);
                        sb.append(".");
                        sb.append(s4);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
        
    }
    private boolean check(String s){
        if(s.length()==0){
            return false;
        }
        if(s.length()==1){
            return true;
        }
        if(s.length()>3){
            return false;
        }
        if(s.charAt(0)=='0'){
            return false;
        }
        if(Integer.parseInt(s)<=255){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        String s = "012";
        System.out.println(Integer.parseInt(s));
    }
}