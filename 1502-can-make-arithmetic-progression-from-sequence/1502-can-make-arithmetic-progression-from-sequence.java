import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // 1. Sayıları küçükten büyüğe sırala
        Arrays.sort(arr);

        // 2. Olması gereken sabit farkı ilk iki elemandan belirle
        int diff = arr[1] - arr[0];

        // 3. Dizinin geri kalanındaki farkları kontrol et
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false; // Fark bozulduğu anda false dön
            }
        }

        return true; // Tüm farklar eşitse true dön
    }
}