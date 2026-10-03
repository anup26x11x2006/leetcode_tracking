class Solution {
public:
    int longestValidParentheses(string s) {
        int n=s.length();
        vector<int> indices;
        stack<int> st;
        for(int i=0; i<n; ++i){
            if(s[i]=='('){
                st.push(i);
            }
            else{
                if(!st.empty()){
                    int idx=st.top();
                    st.pop();
                    indices.push_back(idx);
                    indices.push_back(i);
                }
            }
        }
        sort(indices.begin(), indices.end());
        n=indices.size();
        int ans=0;
        int len=1;
        for(int i=1; i<n; ++i){
            if(indices[i]==(indices[i-1]+1)) len++;
            else{
                if(!(len&1)) ans=max(ans, len);
                len=1;
            }
        }
        if(!(len&1)) ans=max(ans, len);
        return ans;
    }
};