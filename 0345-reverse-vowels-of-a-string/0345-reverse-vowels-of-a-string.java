class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Sol işaretçi sesli harf bulana kadar ilerlesin
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            // Sağ işaretçi sesli harf bulana kadar gerilesin
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            // İkisi de sesli harfte durduysa yerlerini değiştir (swap)
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    // Harfin sesli olup olmadığını kontrol eden yardımcı metot
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}