class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string>ans;
        unordered_map<string,int>m;

        for(int i=0;i+10<=s.size();i++){
            string DNA = s.substr(i,10);
            m[DNA]++;
        }

        for(auto it : m){
            if(it.second > 1){
                ans.push_back(it.first);
            }
        }
        return ans;
    }
};