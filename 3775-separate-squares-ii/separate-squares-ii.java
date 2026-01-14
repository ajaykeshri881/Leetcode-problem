class Solution {
    static class Event {
        long y;
        int type;
        long x1, x2;

        Event(long y, int type, long x1, long x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class Area {
        long y;
        long h;
        long w;

        Area(long y, long h, long w) {
            this.y = y;
            this.h = h;
            this.w = w;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort((a, b) -> Long.compare(a.y, b.y));

        List<long[]> xs = new ArrayList<>();
        List<Area> areas = new ArrayList<>();

        long prevY = events.get(0).y;
        double total = 0;

        for (Event e : events) {
            if (e.y > prevY && !xs.isEmpty()) {
                long h = e.y - prevY;
                long w = unionLen(xs);
                areas.add(new Area(prevY, h, w));
                total += (double) h * w;
            }

            if (e.type == 1) {
                xs.add(new long[]{e.x1, e.x2});
            } else {
                for (int i = 0; i < xs.size(); i++) {
                    if (xs.get(i)[0] == e.x1 && xs.get(i)[1] == e.x2) {
                        xs.remove(i);
                        break;
                    }
                }
            }
            prevY = e.y;
        }

        double half = total / 2;
        double acc = 0;

        for (Area a : areas) {
            double cur = (double) a.h * a.w;
            if (acc + cur >= half) {
                return a.y + (half - acc) / a.w;
            }
            acc += cur;
        }

        return 0.0;
    }

    private long unionLen(List<long[]> intervals) {
        intervals.sort(Comparator.comparingLong(a -> a[0]));
        long res = 0;
        long end = Long.MIN_VALUE;

        for (long[] in : intervals) {
            if (in[0] > end) {
                res += in[1] - in[0];
                end = in[1];
            } else if (in[1] > end) {
                res += in[1] - end;
                end = in[1];
            }
        }
        return res;
    }
}