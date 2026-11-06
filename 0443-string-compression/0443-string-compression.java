class Solution {
    public int compress(char[] chars) {
        int write = 0; // Sıkıştırılmış karakterlerin yazılacağı indeks
        int read = 0;  // Orijinal diziyi tarayan indeks

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Aynı karaktere sahip bloğu say
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // 1. Harfin kendisini yaz
            chars[write++] = currentChar;

            // 2. Eğer birden fazla tekrar varsa sayıyı basamak basamak yaz
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        // write işaretçisinin son konumu, yeni dizinin uzunluğudur
        return write;
    }
}