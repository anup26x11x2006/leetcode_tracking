class Solution {
    public int jump(int[] nums) {
        int ans = 0;   // number of minimum jumps taken
        int end = 0;   // end of the current jump range 
        int farthest = 0;  // farthest index we can reach from current level

        // we stop at nums.length - 1 beacase once we reach or pass it, we're done

        for(int i = 0; i < nums.length - 1; ++i){
            // update the farthest reachable index from the current position
            farthest = Math.max(farthest, i + nums[i]);

            // If we can already reach or pass the last index,
            // take one more jump and finish
            if(farthest >= nums.length - 1){
                ++ans;
                break;
            }

            // when we've iterated through the current "level" (jump range),
            // it's time to make next jump
            if( i == end ){
                ++ans; // increase the jump count
                end = farthest; // update the boundry for the next level
            }             
        }
        return ans;        
    }
}