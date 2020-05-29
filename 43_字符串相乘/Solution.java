
// 字符串乘法
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int tmp = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int s = tmp+res[p2];
                res[p1] += s/10;
                res[p2] = s%10;
            }
        }
        int j = 0;
        for(j=0;j<res.length;j++){
            if(res[j]!=0){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(;j<res.length;j++){
            sb.append(res[j]);
        }
        
        return sb.length()==0?"0":sb.toString();
    }
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "45";
        System.out.println(new Solution().multiply(s1, s2));
    }
}