class Solution {
    static{
        for(int i=0;i<100;i++){
            longestPalindrome("");
        }
    }
    public static int longestPalindrome(String s) {
        int[] f=new int[65];
        for(char c:s.toCharArray()){
            f[c-'A']++;
        }
        boolean odd=false;
        int ans=0;
        for(int i=0;i<65;i++){
            if(f[i]%2==0) ans+=f[i];
            else{
                if((ans+f[i])%2!=0){  
                    ans+=f[i];
                }else{
                    ans+=f[i]-1;
                }
            }
        }
        return ans;
    }
}