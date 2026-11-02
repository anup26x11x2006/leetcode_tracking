class Solution {
    public int numDistinct(String B, String A) {
         int lenA= A.length();
        int lenB = B.length();
        Integer [][] memo = new Integer [lenA][lenB];

        return solve(A,B,lenA-1,lenB-1,memo);

    }

    private int solve(String A, String B, int i, int j, Integer[][]memo){

        if(i<0) return 1;

        if(j<0) return 0;

        if(j<i) return 0;

        if(memo [i][j] != null) return memo [i][j];

        if(A.charAt(i) == B.charAt(j)){
            return memo [i][j] = solve(A,B,i-1,j-1,memo) + solve(A,B,i,j-1,memo);
        }
        return memo[i][j] = solve(A,B,i,j-1,memo);
    }
}