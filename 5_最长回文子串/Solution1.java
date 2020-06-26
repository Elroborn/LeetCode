class Solution1 {
    public String longestPalindrome(String s) {
        //遍历所有i找到以i为中心的 最长回文子串，
        //但为了避免有些偶数串，所以还要看以i和i+1为中心的
        String res = "";
        for(int i=0;i<s.length();i++){
            String s1 = find(s, i, i); //i为中心
            String s2 = find(s, i, i+1);//i和i+1为中心
            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return res;
    }
    public String find(String s,int l,int r){ //找以l r为中心的向左右扩散的最长回文串，之所有用 l r是防止奇偶，对于偶数，直接l r 对于奇数可以l l,如果只有一个参数，则无法处理
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);

    }
}