package leetcode;

import helper.Point;

import java.util.*;

/**
 * Created by xinghuangxu on 4/19/16.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            Map<String, List<Integer>> map = new HashMap();
            int same = 1;
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i], p2 = points[j];
                if (p1.y == p2.y && p1.x == p2.x) {
                    same++;
                } else {
                    int y = p1.y - p2.y, x = p1.x - p2.x;
                    int gcd = gcd(y, x);
                    gcd = gcd == 0 ? 1 : gcd;
                    String k = (y / gcd) + "/" + (x / gcd);
                    if (!map.containsKey(k)) {
                        map.put(k, new ArrayList());
                    }
                    map.get(k).add(j);
                }
            }
            if (same > max) max = same;
            for (String k : map.keySet()) {
                if (map.get(k).size() + same > max) {
                    max = map.get(k).size() + same;
                }
            }
        }
        return max;
    }

    private int gcd(int y, int x) {
        if (x == 0) return y;
        return gcd(x, y % x);
    }
}
