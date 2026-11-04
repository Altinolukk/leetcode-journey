class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Boşlukları atla
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            int end = i;

            // Kelimenin başına kadar git
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Kelimeyi sonuca ekle
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, end + 1));
        }

        return result.toString();
    }
}