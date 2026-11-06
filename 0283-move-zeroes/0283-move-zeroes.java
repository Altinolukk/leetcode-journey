class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // Sıfır olmayan sayının gelmesi gereken yer

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Eğer zaten aynı indekste değillerse takas yap
                if (i != insertPos) {
                    int temp = nums[insertPos];
                    nums[insertPos] = nums[i];
                    nums[i] = temp;
                }
                insertPos++;
            }
        }
    }
}