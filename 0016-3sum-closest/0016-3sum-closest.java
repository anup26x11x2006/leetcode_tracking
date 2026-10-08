class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int n = nums.length;

       Quicksort(nums,0,n-1);

       int closestSum = nums[0] + nums[1] + nums[2];

       for(int i=0;i<n-2;i++){

        int left = i+1;
        int right = n-1;

        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }

        int minsum = nums[left] + nums[left+1] + nums[i];

        if(minsum > target){
            if(Math.abs(minsum - target)<Math.abs(closestSum - target))
                closestSum = minsum;
            break;
        }

        int maxsum = nums[i] + nums[right] + nums[right-1];


       if (maxsum < target ){
         if(Math.abs(maxsum - target)<Math.abs(closestSum - target))
                closestSum = maxsum;
        continue;
       }

       while(left<right){

        int sum = nums[i] + nums[left] + nums[right];

        if(sum == target){
            return sum;

        }

        if(Math.abs(target - sum)<Math.abs(target-closestSum))
            closestSum = sum;

        if(sum < target){
            left++;

            while (left<right && nums[left]== nums[left-1])
                left++;
        }
       

        else{
            right--;

            while (left<right && nums[right]== nums[right+1])
                right--;
        }
       } }

       
       return closestSum;
    }

    private void Quicksort(int[] arr,int low,int high){

        if(low>=high){
            return ;
        }

        if(arr[low]>arr[high])
            swap(arr,low,high);

        int lt = low +1;
        int i = low + 1;
        int gt = high - 1;

       int  pivot1 = arr[low];
    int pivot2 = arr[high];

        while(i <= gt){
            if(arr[i]<pivot1)
                swap(arr,i++,lt++);
            else if (arr[i]>pivot2)
                swap(arr,i,gt--);
            else
                i++;
        }

        swap(arr,low,--lt);
        swap(arr,high,++gt);

        Quicksort(arr,low,lt-1);

        if(pivot1 < pivot2)
             Quicksort(arr,lt+1,gt-1);

        Quicksort(arr,gt+1,high);
    }

    private void swap(int[] arr, int i, int j) {
         int temp = arr[i];
          arr[i] = arr[j];
           arr[j] = temp; }
}