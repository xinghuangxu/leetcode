package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinghuangxu on 10/27/15.
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int xOverlap = Math.max(0, Math.min(C, G) - Math.max(A, E));
        int yOverlap = Math.max(0, Math.min(D, H) - Math.max(B, F));
        return (D - B) * (C - A) + (H - F) * (G - E) - xOverlap * yOverlap;
    }


    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {

        int firstSize = Math.abs(A - C) * Math.abs(B - D);
        int secondSize = Math.abs(E - G) * Math.abs(F - H);

        if (!isOverlap(A, B, C, D, E, F, G, H)) {
            return firstSize + secondSize;
        }
        int[] xs = new int[]{A, C, E, G};
        int[] ys = new int[]{B, D, F, H};
        Arrays.sort(xs);
        Arrays.sort(ys);
        return firstSize + secondSize - Math.abs(xs[1] - xs[2]) * Math.abs(ys[1] - ys[2]);
    }

    public boolean isOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        //if one is on left of the other
        if (E > C || A > G) {
            return false;
        }
        //if one is above another
        if (B > H || F > D) {
            return false;
        }
        return true;
    }

    /* Sample Solution:
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    if (A >= G || E >= C || B >= H || F >= D) return (C - A) * (D - B) + (G - E) * (H - F);
    int x1 = Math.max(A, E);
    int y1 = Math.max(B, F);
    int x2 = Math.min(C, G);
    int y2 = Math.min(D, H);
    return (C - A) * (D - B) + (G - E) * (H - F) - (x2 - x1) * (y2 -y1);
}
     */
    /*
    The overlap area can be calculated as!!:

  x_overlap = Math.max(0, Math.min(x12,x22) - Math.max(x11,x21));
  y_overlap = Math.max(0, Math.min(y12,y22) - Math.max(y11,y21));
  overlapArea = x_overlap * y_overlap;
     */
}
