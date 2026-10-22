class Solution {
    public int numRookCaptures(char[][] arr) {
        int strike=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(arr[i][j]=='R'){
                    for(int k=i-1;k>=0;k--){
                        if(arr[k][j]=='B') break;
                        else if(arr[k][j]=='p'){
                            strike++;
                            break;
                        }
                    }
                    for(int k=i+1;k<8;k++){
                        if(arr[k][j]=='B') break;
                        else if(arr[k][j]=='p'){
                            strike++;
                            break;
                        }
                    }
                    for(int k=j-1;k>=0;k--){
                        if(arr[i][k]=='B') break;
                        else if(arr[i][k]=='p'){
                            strike++;
                            break;
                        }
                    }
                    for(int k=j+1;k<8;k++){
                        if(arr[i][k]=='B') break;
                        else if(arr[i][k]=='p'){
                            strike++;
                            break;
                        }
                    }
                    
                }
            }
        }
        return strike;
    }
}