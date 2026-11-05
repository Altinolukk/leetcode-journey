class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;             // En küçük sayıyı güncelle
            } else if (num <= second) {
                second = num;            // Ortanca sayıyı güncelle
            } else {
                return true;             // first < second < num sağlandı
            }
        }

        return false;
    }
}