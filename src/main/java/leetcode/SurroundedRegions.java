package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by k586j642 on 4/14/2016.
 */
public class SurroundedRegions {
    class Point{
        boolean safe = false;
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        void safe(){
            this.safe =true;
        }
    }
    class OPoint extends Point{
        OPoint(int x, int y) {
            super(x, y);
        }
    }

    public void solve(char[][] board) {
        int rowCount = board.length;
        if(rowCount==1)return;
        int columnCount = board[0].length;
        Point[][] points = new Point[rowCount][columnCount];
        Queue<Point> escapePoint = new ArrayDeque();
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                if(board[i][j]=='X'){
                    points[i][j] = new Point(i,j);
                }else{
                    points[i][j] = new OPoint(i,j);
                    if(i==0||i==rowCount-1||j==0||j==columnCount-1){
                        points[i][j].safe();
                        escapePoint.add(points[i][j]);
                    }
                }
            }
        }
        while(!escapePoint.isEmpty()){ //depth first search
            Point tmp = escapePoint.poll();
            List<Point> directions = new ArrayList(4);
            if(tmp.x-1>0){
                directions.add(points[tmp.x-1][tmp.y]);
            }
            if(tmp.x+1<rowCount){
                directions.add(points[tmp.x+1][tmp.y]);
            }
            if(tmp.y-1>0){
                directions.add(points[tmp.x][tmp.y-1]);
            }
            if(tmp.y+1<columnCount){
                directions.add(points[tmp.x][tmp.y+1]);
            }
            for(Point d:directions){
                if( d instanceof OPoint && !d.safe){
                    escapePoint.add(d);
                    d.safe();
                }
            }
        }
        for(int i=0;i<rowCount;i++) {
            for (int j = 0; j < columnCount; j++) {
                if(points[i][j] instanceof OPoint && !points[i][j].safe){
                    board[i][j]='X';
                }
            }
        }
    }
}
