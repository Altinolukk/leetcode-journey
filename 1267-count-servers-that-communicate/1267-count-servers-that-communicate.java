class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Her satırdaki ve her sütundaki sunucu sayılarını tutacak diziler
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // 1. Adım: Satır ve sütunlardaki sunucu sayılarını hesapla
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int communicableServers = 0;

        // 2. Adım: Aynı satırda veya sütunda birden fazla sunucu var mı kontrol et
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Bulunduğu satırda veya sütunda en az 2 sunucu varsa iletişim kurabilir
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        communicableServers++;
                    }
                }
            }
        }

        return communicableServers;
    }
}