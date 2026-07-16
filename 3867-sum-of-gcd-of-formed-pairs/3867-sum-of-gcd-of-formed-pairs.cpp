class Solution {
public:
    long long gcdSum(vector<int>& nums) {
        int xMax=0, n=nums.size();
        for(int& x: nums){
            xMax=max(x, xMax);
            x=gcd(x, xMax);
        }
        sort(nums.begin(), nums.end());
        long long sum=0;
        for(int l=0, r=n-1; l<r; l++, r--)
            sum+=gcd(nums[l], nums[r]);
        return sum;
    }
};