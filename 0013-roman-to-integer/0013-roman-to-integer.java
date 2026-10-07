class Solution {
     public static int chartoInt(char c){
        int num = 0;
        switch (c){

            case 'I': num = 1;
            break;
            case 'V': num =5;
                break;
            case 'X' : num =10;
            break;
            case 'L': num =50;
            break;
            case 'C': num =100;
            break;
            case 'D' :num =500;
            break;
            case 'M' : num =1000;
            break;
            default: return 0;
        }
        return num;
    }
    public int romanToInt(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i< arr.length; i++)
        {
            arr[i] = chartoInt(s.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]< arr[i+1])
            {
                sum-=arr[i];
            }
            else {
                sum+= arr[i];
            }
        }
        sum+=arr[arr.length-1];
        return sum;
    }
}