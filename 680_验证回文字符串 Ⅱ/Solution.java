class Solution {
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        int i=0,j = ch.length-1;
        while(i<j){
            if(ch[i]==ch[j]){
                i++;
                j--;
            }else{
                //分两种情况，从这个位置断开，要么看low+1 -hight，要么看low -high-1，两个有一个真即可
                boolean flage1 = true,flage2 = true;
                int low = i+1,high = j;
                while(low<high){
                    if(ch[low]==ch[high]){
                        low++;
                        high--;
                    }else{
                        flage1 = false;
                        break;
                    }
                }
                low = i;
                high = j-1;
                while(low<high){
                    if(ch[low]==ch[high]){
                        low++;
                        high--;
                    }else{
                        flage2 = false;
                        break;
                    }
                }
                return flage1 || flage2;
            }
        }
        return true;

    }
}