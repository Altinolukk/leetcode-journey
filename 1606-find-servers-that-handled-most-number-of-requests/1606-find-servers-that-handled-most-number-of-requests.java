import java.util.*;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Her sunucunun işlediği istek sayacı
        int[] requestCounts = new int[k];
        
        // Boştaki sunucu ID'lerini sıralı tutan ağaç
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        // Meşgul sunucuları bitiş zamanına göre tutan Min-Heap: [endTime, serverId]
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        int n = arrival.length;
        
        for (int i = 0; i < n; i++) {
            int curTime = arrival[i];
            int duration = load[i];
            
            // 1. İşi bitmiş sunucuları boşalt ve availableServers'a ekle
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= curTime) {
                int[] finished = busyServers.poll();
                availableServers.add(finished[1]);
            }
            
            // Eğer boşta hiç sunucu kalmadıysa istek düşer
            if (availableServers.isEmpty()) {
                continue;
            }
            
            // 2. Tercih edilen sunucu: i % k
            int preferred = i % k;
            
            // Önce [preferred, k - 1] aralığında ara
            Integer assigned = availableServers.ceiling(preferred);
            
            // Bulunamazsa başa sar: [0, preferred - 1] aralığındaki ilk sunucuyu al
            if (assigned == null) {
                assigned = availableServers.first();
            }
            
            // 3. Sunucuya görevi ata
            availableServers.remove(assigned);
            busyServers.offer(new int[]{curTime + duration, assigned});
            requestCounts[assigned]++;
        }
        
        // 4. En yüksek istek sayısını bul
        int maxRequests = 0;
        for (int count : requestCounts) {
            if (count > maxRequests) {
                maxRequests = count;
            }
        }
        
        // 5. En yüksek sayıya ulaşan tüm sunucuları topla
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCounts[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}