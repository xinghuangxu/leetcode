package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 8/21/2015.
 */
public class MaximalSquare {

    char[][] matrix;
    int[][] scores;
    int rowCount;
    int columnCount;

    //Dynamic Programming
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        rowCount = matrix.length;
        if (rowCount == 0) return maxSize;
        columnCount = matrix[0].length;
        this.matrix = matrix;
        this.scores = new int[rowCount][columnCount];
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (matrix[j][i] == '1') {
                    scores[j][i] = Math.min(getScore(j - 1, i), Math.min(getScore(j, i - 1), getScore(j - 1, i - 1))) +1;
                    if (scores[j][i] > maxSize) {
                        maxSize = scores[j][i];
                    }
                }
            }
        }
        return maxSize * maxSize;
    }

    private int getScore(int x, int y) {
        if (x < 0 || x >= rowCount || y < 0 || y >= columnCount) return 0;
        return scores[x][y];
    }

//    int columnCount;
//    int rowCount;
//    Point[][] points;
//    Set<String> mem = new HashSet<String>();
//
//    class Point {
//        int x, y;
//
//        public String getHashKey() {
//            return String.format("(%d,%d)", x, y);
//        }
//    }
//
//    class Square {
//        Point topLeft;
//        Point bottomRight;
//        int size;
//
//        public Square(Point topLeft, Point bottomRight, int size) {
//            this.topLeft = topLeft;
//            this.bottomRight = bottomRight;
//            this.size = size;
//        }
//
//        public String getHashKey() {
//            return topLeft.getHashKey() + bottomRight.getHashKey();
//        }
//    }
//
//    public int maximalSquare(char[][] matrix) {
//        int maxSize = 0;
//        rowCount = matrix.length;
//        if (rowCount == 0) return maxSize;
//        columnCount = matrix[0].length;
//        points = new Point[rowCount][columnCount];
//        Queue<Square> squareQueue = new ArrayDeque<Square>();
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                if (matrix[i][j] == '1') {
//                    Point point = new Point();
//                    point.x = i;
//                    point.y = j;
//                    points[i][j] = point;
//                    Square square = new Square(point, point, 1);
//                    squareQueue.add(square);
//                }
//            }
//        }
//        while (!squareQueue.isEmpty()) {
//            Square tSquare = squareQueue.poll();
//            if (tSquare.size > maxSize) {
//                maxSize = tSquare.size;
//            }
//            List<Square> expandedSquares = expand(tSquare);
//            for (Square square : expandedSquares) {
//                String hashKey = square.getHashKey();
//                if (!mem.contains(hashKey)) {
//                    squareQueue.add(square);
//                    mem.add(hashKey);
//                }
//            }
//        }
//        return maxSize * maxSize;
//    }
//
//    private List<Square> expand(Square square) {
//        List<Square> squares = new ArrayList<Square>(4);
//        boolean top = true, bottom = true, left = true, right = true;
//        Point topLeft = square.topLeft;
//        Point bottomRight = square.bottomRight;
//        //top
//        for (int i = topLeft.x; top && i <= bottomRight.x; i++) {
//            if (isNull(i, topLeft.y - 1)) {
//                top = false;
//            }
//        }
//
//        //bottom
//        for (int i = topLeft.x; bottom && i <= bottomRight.x; i++) {
//            if (isNull(i, bottomRight.y + 1)) {
//                bottom = false;
//            }
//        }
//
//        //left
//        for (int i = topLeft.y; left && i <= bottomRight.y; i++) {
//            if (isNull(topLeft.x - 1, i)) {
//                left = false;
//            }
//        }
//
//        //right
//        for (int i = topLeft.y; right && i <= bottomRight.y; i++) {
//            if (isNull(bottomRight.x + 1, i)) {
//                right = false;
//            }
//        }
//
//        //topLeft
//        if (!isNull(topLeft.x - 1, topLeft.y - 1) && top && left) {
//            squares.add(new Square(points[topLeft.x - 1][topLeft.y - 1], bottomRight, square.size + 1));
//        }
//        //topRight
//        if (!isNull(bottomRight.x + 1, topLeft.y - 1) && top && right) {
//            squares.add(new Square(points[topLeft.x][topLeft.y - 1], points[bottomRight.x + 1][bottomRight.y], square.size + 1));
//        }
//        //bottomLeft
//        if (!isNull(topLeft.x - 1, bottomRight.y + 1) && left && bottom) {
//            squares.add(new Square(points[topLeft.x - 1][topLeft.y], points[bottomRight.x][bottomRight.y + 1], square.size + 1));
//        }
//        //bottomRight
//        if (!isNull(bottomRight.x + 1, bottomRight.y + 1) && right && bottom) {
//            squares.add(new Square(topLeft, points[bottomRight.x + 1][bottomRight.y + 1], square.size + 1));
//        }
//
//        return squares;
//    }
//
//    private boolean isNull(int x, int y) {
//        if (x < 0 || x >= rowCount || y < 0 || y >= columnCount) return true;
//        return points[x][y] == null;
//    }
}
