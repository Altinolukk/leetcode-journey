class Solution {
    public String mergeAlternately(String word1, String word2) {
        String e = "";
        int len1 = word1.length();
        int len2 = word2.length();
        
        // Kısa olan uzunluğu bul
        int minLen = Math.min(len1, len2);

        // Kısa olanın bittiği yere kadar teker teker ekle
        for (int i = 0; i < minLen; i++) {
            e = e + word1.charAt(i);
            e = e + word2.charAt(i);
        }

        // word1 daha uzunsa kalan harflerini ekle
        if (len1 > len2) {
            for (int i = minLen; i < len1; i++) {
                e = e + word1.charAt(i);
            }
        } 
        // word2 daha uzunsa kalan harflerini ekle
        else if (len2 > len1) {
            for (int i = minLen; i < len2; i++) {
                e = e + word2.charAt(i);
            }
        }

        return e;
    }
}