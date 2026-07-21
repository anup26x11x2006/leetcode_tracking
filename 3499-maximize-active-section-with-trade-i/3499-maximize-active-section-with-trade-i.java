class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int oneCount = 0;
        int maxMergedzeros = 0;
        int currZeroCount = 0;
        int lastZeroCount = 0;
        for(char c : s.toCharArray()){
            if(c == '0') currZeroCount++;
            else {
                if(currZeroCount != 0) lastZeroCount = currZeroCount;
                currZeroCount = 0;
                oneCount++;
            }
            maxMergedzeros = Math.max(maxMergedzeros, currZeroCount + lastZeroCount);
        }
        if(maxMergedzeros == currZeroCount || maxMergedzeros == lastZeroCount) return oneCount;
        return oneCount + maxMergedzeros;
    }
}