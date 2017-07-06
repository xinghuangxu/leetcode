package leetcode;


public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isSquare(p1, p2, p3, p4) || isSquare(p1, p3, p2, p4) || isSquare(p1, p4, p2, p3);
    }

    private boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isPerpendicular(p1, p2, p3, p4) && isEqualInLength(p1, p2, p3, p4);
    }

    private boolean isEqualInLength(int[] p1, int[] p2, int[] p3, int[] p4) {
        return getLengthSqrt(p1, p2) == getLengthSqrt(p3, p4);
    }

    private double getLengthSqrt(int[] p1, int[] p2) {
        return Math.sqrt(p1[0] - p2[0]) + Math.sqrt(p1[1] - p2[1]);
    }

    private boolean isPerpendicular(int[] p1, int[] p2, int[] p3, int[] p4) {
        int y1 = p1[1] - p2[1];
        int x1 = p1[0] - p2[0];

        int y2 = p3[1] - p4[1];
        int x2 = p3[0] - p4[0];

        int y = y1 - y2;
        return false;
    }


}
