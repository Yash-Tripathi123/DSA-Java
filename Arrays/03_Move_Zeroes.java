class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; 
        for(int j=i; j<nums.length; j++){
            if (nums[j]!=0 ){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}