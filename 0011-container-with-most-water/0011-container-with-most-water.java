class Solution {
    public int maxArea(int[] height) {
        int left = 0;                         // En soldaki duvar
        int right = height.length - 1;        // En sağdaki duvar
        int maxWater = 0;                     // Tutulan maksimum su miktarı

        while (left < right) {
            // İki duvar arasındaki mesafe (genişlik)
            int width = right - left;
            
            // Suyun yüksekliğini belirleyen kısa duvar
            int minHeight = Math.min(height[left], height[right]);
            
            // Mevcut alan
            int currentArea = width * minHeight;
            
            // Maksimum alanı güncelle
            if (currentArea > maxWater) {
                maxWater = currentArea;
            }

            // Kısa olan duvarı içeri doğru kaydır
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}