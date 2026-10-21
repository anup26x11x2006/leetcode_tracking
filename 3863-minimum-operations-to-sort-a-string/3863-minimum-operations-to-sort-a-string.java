class Solution {

    boolean isSorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) < s.charAt(i-1))return false;
        }
        return true;
    }

    public int minOperations(String s) {
        int n = s.length();
        if(isSorted(s))return 0;
        if(n==2)return -1;
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int first = 0, last = 25;
        while(freq[first]==0)first++;
        while(freq[last]==0)last--;
        if(s.charAt(0)-'a' == first){
            return 1;
        }
        else if(s.charAt(n-1)-'a' == last)return 1;
        else if(s.charAt(0)-'a' != last || s.charAt(n-1)-'a' != first || freq[first] > 1 || freq[last] > 1)return 2;
        else return 3;
    }
}