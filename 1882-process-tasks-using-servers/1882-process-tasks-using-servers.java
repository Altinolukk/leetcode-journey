import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Boşta olan sunucular: [weight, index]
        // Öncelik: küçük weight -> küçük index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Başlangıçta tüm sunucular boşta
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        // Çalışan sunucular: [freeTime, weight, index]
        // Öncelik: küçük freeTime -> küçük weight -> küçük index
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[2], b[2]);
        });

        long currentTime = 0;

        for (int j = 0; j < m; j++) {
            // Görev en erken j. saniyede sıraya girer
            currentTime = Math.max(currentTime, j);

            // Boşta sunucu yoksa, zamanı en erken boşa çıkacak sunucunun bitiş anına sar
            if (freeServers.isEmpty()) {
                currentTime = busyServers.peek()[0];
            }

            // currentTime anına kadar işini tamamlamış olan tüm sunucuları boşa al
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                long[] server = busyServers.poll();
                freeServers.offer(new int[]{(int) server[1], (int) server[2]});
            }

            // En uygun boş sunucuyu seç ve görevi ata
            int[] bestServer = freeServers.poll();
            int weight = bestServer[0];
            int index = bestServer[1];

            ans[j] = index;

            // Sunucuyu çalışanlar kuyruğuna gönder
            busyServers.offer(new long[]{currentTime + tasks[j], weight, index});
        }

        return ans;
    }
}