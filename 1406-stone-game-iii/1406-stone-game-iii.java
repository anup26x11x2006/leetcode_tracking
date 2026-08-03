class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int sufSum = 0;
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            sufSum += stoneValue[i];
            int newF = sufSum - Math.min(Math.min(f1, f2), f3);
            f3 = f2;
            f2 = f1;
            f1 = newF;
        }

        int diff = f1 - (sufSum - f1);
        if (diff == 0) {
            return "Tie";
        }
        return diff > 0 ? "Alice" : "Bob";
    }
}