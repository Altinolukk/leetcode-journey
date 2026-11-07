class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // s için işaretçi
        int j = 0; // t için işaretçi

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // s'teki aradığımız harf bulundu, sıradakine geç
            }
            j++; // t'de her halükarda ilerle
        }

        // Eğer s'in tüm harflerini bulduysak i uzunluğa eşit olur
        return i == s.length();
    }
}