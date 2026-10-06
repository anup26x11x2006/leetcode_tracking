class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int freq[101] = {};
        int maxFreq = 0, maxVal = 0;

        for (int x : nums) {
            ++freq[x];
            maxFreq = max(maxFreq, freq[x]);
            maxVal = max(maxVal, x);
        }

        vector<int> ans;
        ans.reserve(nums.size());

        for (int round = 1; round <= maxFreq; ++round) {
            for (int v = 1; v <= maxVal; ++v) {
                if (freq[v] >= round) {
                    ans.push_back(v);
                }
            }
        }

        return ans;
    }
};