class Solution {
    public int[] rearrangeArray(int[] nums) {
        int freq[] = new int[101];
        int n = nums.length;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        int ans[]= new int[n];
        int x = 0 ; 
        while(x<n){
            for(int i=0;i<=100;i++){
                if(freq[i]>0){
                    ans[x++] = i;
                    freq[i]-- ;
                }
            }
        }
        return ans;
    }
}