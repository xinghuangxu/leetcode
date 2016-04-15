package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class WallsAndGates {

    class Gate extends Point {


        Gate(int x, int y) {
            super(x, y);
            this.distanceToGate = 0;
            value = 0;
        }
    }

    void propagate(Point currentPoint, Stack<Point> stack, Point[][] points, int rowCount, int columnCount) { //depth first search; 1 step forward
        List<Point> directions = new ArrayList(4);
        //propagate directions 4 directions to go
        if (currentPoint.y - 1 > -1) {//left
            directions.add(points[currentPoint.x][currentPoint.y - 1]);
        }
        if (currentPoint.y + 1 < columnCount) {//right
            directions.add(points[currentPoint.x][currentPoint.y + 1]);
        }
        if (currentPoint.x - 1 > -1) {
            directions.add(points[currentPoint.x - 1][currentPoint.y]);
        }
        if (currentPoint.x + 1 < rowCount) {
            directions.add(points[currentPoint.x + 1][currentPoint.y]);
        }
        for (Point point : directions) {
            if (point instanceof Path && point.distanceToGate == null) {
                point.distanceToGate = currentPoint.distanceToGate + 1;
                stack.add(point);
            }
        }
    }

    class Wall extends Point {

        Wall(int x, int y) {
            super(x, y);
            distanceToGate = Integer.MAX_VALUE;
            value = -1;
        }
    }

    class Path extends Point {

        Path(int x, int y) {
            super(x, y);
        }
    }

    class Point {
        int value;
        int x, y;
        Integer distanceToGate = null;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        int INFINITY = 2147483647, GATE = 0, WALL = -1;
        int rowCount = rooms.length;
        if(rowCount==0)return;
        int columnCount = rooms[0].length;
        Queue<Stack<Point>> gates = new ArrayDeque();
        Point[][] points = new Point[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (rooms[i][j] == GATE) {
                    points[i][j] = new Gate(i, j);
                    Stack<Point> front = new Stack();
                    front.add(points[i][j]);
                    gates.add(front);
                } else if (rooms[i][j] == INFINITY) {
                    points[i][j] = new Path(i, j);
                } else if (rooms[i][j] == WALL) {
                    points[i][j] = new Wall(i, j);
                }
            }
        }
        while (!gates.isEmpty()) {
            Stack<Point> front = gates.poll();
            Stack<Point> tmp = new Stack();
            for (Point p : front) {
                propagate(p, tmp, points, rowCount, columnCount);
            }
            if (tmp.size() > 0) {
                gates.add(tmp);
            }
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (points[i][j] instanceof Path) {
                    if (points[i][j].distanceToGate != null) {
                        rooms[i][j] = points[i][j].distanceToGate;
                    }
                }
            }
        }
    }
}
