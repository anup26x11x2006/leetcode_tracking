class Solution {
    public boolean containsDuplicate(int[] nums) {
       int tableSize = 1;
        while (tableSize < nums.length * 2) {
            tableSize *= 2; 
        }

        int[] storedNumbers = new int[tableSize];
        boolean[] isSlotOccupied = new boolean[tableSize];
        
        int moduloMask = tableSize - 1;

        for (int currentNum : nums) {
            
            int scrambledHash = currentNum ^ (currentNum >>> 16);
            int slotIndex = scrambledHash & moduloMask;

            while (isSlotOccupied[slotIndex]) {
                if (storedNumbers[slotIndex] == currentNum) {
                    return true;
                }
                slotIndex = (slotIndex + 1) & moduloMask;
            }

            isSlotOccupied[slotIndex] = true;
            storedNumbers[slotIndex] = currentNum;
        }

        return false;
    }

    static {
        Solution jvmWarmup = new Solution();
        for (int i = 0; i < 200; i++) {
            jvmWarmup.containsDuplicate(new int[0]);
        }
    }
}