import java.util.*;

class Router {
    private int memLimit;
    private Queue<Packet> queue;
    private Set<String> packetSet;
    private Map<Integer, DestinationTimestamps> destMap;

    public Router(int memLimit) {
        this.memLimit = memLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false;
        if (queue.size() == memLimit) {
            Packet old = queue.poll();
            String oldKey = old.source + "#" + old.destination + "#" + old.timestamp;
            packetSet.remove(oldKey);
            DestinationTimestamps dt = destMap.get(old.destination);
            dt.pointer++;
            if (dt.pointer == dt.timestamps.size()) {
                destMap.remove(old.destination);
            }
        }
        Packet newPkt = new Packet(source, destination, timestamp);
        queue.offer(newPkt);
        packetSet.add(key);
        destMap.putIfAbsent(destination, new DestinationTimestamps());
        destMap.get(destination).timestamps.add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        Packet pkt = queue.poll();
        String key = pkt.source + "#" + pkt.destination + "#" + pkt.timestamp;
        packetSet.remove(key);
        DestinationTimestamps dt = destMap.get(pkt.destination);
        dt.pointer++;
        if (dt.pointer == dt.timestamps.size()) {
            destMap.remove(pkt.destination);
        }
        return new int[]{pkt.source, pkt.destination, pkt.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        DestinationTimestamps dt = destMap.get(destination);
        List<Integer> list = dt.timestamps;
        int activeStart = dt.pointer;
        int lo = lowerBound(list, activeStart, list.size(), startTime);
        int hi = upperBound(list, activeStart, list.size(), endTime);
        return hi - lo;
    }

    private int lowerBound(List<Integer> list, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
    }

    private static class DestinationTimestamps {
        List<Integer> timestamps;
        int pointer;
        DestinationTimestamps() {
            timestamps = new ArrayList<>();
            pointer = 0;
        }
    }
}
