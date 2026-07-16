class Solution {
   
    public long gcdSum(int[] arr) {
        int[] prefi = new int[arr.length];
        int mx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
            prefi[i] = gcd(mx, arr[i]);
        }
        Arrays.sort(prefi);
        int i = 0;
        int j = arr.length - 1;
        long sum = 0;
        while (i < j) {
            sum += gcd(prefi[i], prefi[j]);
            i++;
            j--;
        }
        return sum;
    }

     public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}