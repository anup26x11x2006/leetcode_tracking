class Solution {
private:
    void backtrack(string& ans, string& temp, vector<bool>& visited, vector<char>& nums, int& count, int i, int& n, int& k)
    {
        if(i >= n)
        {
            count++;
            if(count == k)
                ans += temp;
            return;
        }
        for(int idx=0; idx<nums.size(); idx++)
        {
            if(!visited[idx])
            {
                temp.push_back(nums[idx]);
                visited[idx] = true;
                backtrack(ans, temp, visited, nums, count, i+1, n, k);
                temp.pop_back();
                visited[idx] = false;
                if(!ans.empty()) return;
            }
        }
    }
public:
    string getPermutation(int n, int k) 
    {
        vector<bool> visited (n,false);
        vector<char> nums;
        int count = 0;
        for(int i=1; i<=n; i++)
            nums.push_back('0' + i);
            
        string temp = "";
        string ans = "";
        backtrack(ans, temp, visited, nums, count, 0, n, k);
        return ans;
    }
};