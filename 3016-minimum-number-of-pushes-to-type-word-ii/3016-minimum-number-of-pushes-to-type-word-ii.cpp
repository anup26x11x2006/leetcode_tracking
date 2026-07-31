class Solution {
public:
    static  void print(auto& c){
        for(int x: c) cout<<x<<", "; 
        cout<<endl;
    }
    static int minimumPushes(string& word) {
        int freq[26]={0};
        for(char c: word) 
            freq[c-'a']++;
        nth_element(freq, freq+7, end(freq), greater<int>());
        nth_element(freq+8, freq+15, end(freq), greater<int>());
        nth_element(freq+16, freq+23, end(freq), greater<int>());

        int i=0; 
        return accumulate(freq, freq+26, 0,  [&i](int sum, int f){
            return sum+=(f*(i++/8+1));
        });
    }
};


auto init = []()
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 'c';
}();