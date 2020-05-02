/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
class GuessGame{
    int pick = 6;
    public int guess(int num){
        if(pick>num){
            return 1;
        }else if(pick<num){
            return -1;
        }else{
            return 0;
        }
    }
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 0,right = n;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(guess(mid)==1){
                left = mid+1;
            }else if(guess(mid)==-1){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}