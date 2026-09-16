class Solution {
public:
    const int MOD=1e9+7;
    long long pow(int x, int n){
        long long base=x, ans=1;
        while(n){
         if(n&1){
            ans = (ans *base)%MOD;
         }
         base = (base*base)%MOD;
         n>>=1;
        }
        return ans;
    }
    long long inv(int n){
        return pow(n,MOD-2);
    }
    int C(int n , int r ){
     long long nr=1,dr1=1,dr2=1;
     for(int i=1;i<=n;i++)nr= (nr*i)%MOD;
     for(int i=n-r;i>=1;i--)dr1= (dr1*i)%MOD;
     for(int i=r;i>=1;i--)dr2=(dr2*i)%MOD;
     return nr * inv(dr1)%MOD * inv(dr2) %MOD; 
    }
    int numberOfSets(int n, int k) {
        return C(n+k-1,2*k);
    }
};