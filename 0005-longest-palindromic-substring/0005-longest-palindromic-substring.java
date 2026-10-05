class Solution {
    public String longestPalindrome(String s) {
        int[] best = new int[]{0,0};
        expandAroundCenter(s.toCharArray(), 0, best);

        return s.substring(best[0], best[1]+1);
    }

    public void expandAroundCenter(char[] carr, int center, int[] best){
        if(center>=carr.length-1){
            return;
        }

        int left = center;
        int right = center;

        while(right+1<carr.length && carr[right]==carr[right+1]){
            right++;
        }

        int nextCenter = right+1;

        while(left-1>=0 && right+1<carr.length && carr[left-1]==carr[right+1]){
            left--;
            right++;
        }

        if(best[1]-best[0] < right-left){
            best[0]=left;
            best[1] = right;
        }

        expandAroundCenter(carr, nextCenter, best);
    }
}