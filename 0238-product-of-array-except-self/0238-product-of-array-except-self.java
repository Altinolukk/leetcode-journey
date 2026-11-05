class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. Adım: Soldaki sayıların çarpımını answer dizisine doldur
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // 2. Adım: Sağdaki sayıların çarpımını hesaplayıp mevcut değerle çarp
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}