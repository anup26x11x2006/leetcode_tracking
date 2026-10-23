class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean neg = false;
        if(num <0) {neg = true;  num = -1*num;}
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int rem = num%7;
            num = num/7;
            sb.append(rem);
        }
        if(neg) sb.append('-');
        sb.reverse();
        return sb.toString();
    }
}