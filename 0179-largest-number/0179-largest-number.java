class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numbers = new String[n];
        boolean isAllZero = true;
        for (int i = 0; i < n; i++) {
            numbers[i] = String.valueOf(nums[i]);
            if (nums[i] != 0) isAllZero = false;
        }
        if (isAllZero) return "0";
        sort(numbers, 0, n - 1); 
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    public void sort(String[] arr, int start, int end) {
        if (start >= end) return;
        String pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (compare(arr[j], pivot, 0, 0)) {
                i++;
                if (i != j) {
                    String s = arr[j];
                    arr[j] = arr[i];
                    arr[i] = s;
                }
            }
        }

        String s = arr[++i];
        arr[i] = pivot;
        arr[end] = s;

        sort(arr, start, i - 1);
        sort(arr, i + 1, end);
    }

    public boolean compare(String s, String t, int i1, int i2) {
        int n = s.length();
        int m = t.length();
        
        while (i1 < n && i2 < m) {
            if (s.charAt(i1) < t.charAt(i2)) return true;
            if (s.charAt(i1) > t.charAt(i2)) return false;
            i1++;
            i2++;
        }
        
        if (i1 < n) {
            return compare(s, t, i1, 0);
        }
        if (i2 < m) {
            return compare(s, t, 0, i2);
        }

        return false;
    }   
}