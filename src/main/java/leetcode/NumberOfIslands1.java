package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class NumberOfIslands1 {
    int rowCount;
    int columnCount;
    public int numIslands(char[][] grid) {
        int id =1;
        rowCount=grid.length;
        if(rowCount == 0)return 0;
        columnCount = grid[0].length;
        int[][] integergrids=new int[rowCount][columnCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                if(grid[i][j]=='1'){
                    integergrids[i][j]=id;
                    id++;
                }else{
                    integergrids[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        boolean stable = false;
        while(!stable){
            stable = true;
            for(int i=0;i<rowCount;i++){
                for(int j=0;j<columnCount;j++){
                    if(grid[i][j]=='1'&&updateMinimumAround(integergrids,i,j)){
                        stable =false;
                    }
                }
            }
        }
        Set<Integer> sets=new HashSet<Integer>();
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                if(grid[i][j]=='1'){
                    sets.add(integergrids[i][j]);
                }
            }
        }
        return sets.size();
    }

    /**
     *
     * @param grid
     * @param i
     * @param j
     * @return true if inDegree got updated
     */
    private boolean updateMinimumAround(int[][] grid, int i, int j) {
        int up=getIslandId(grid,i-1,j);
        int down=getIslandId(grid,i+1,j);
        int left=getIslandId(grid,i,j-1);
        int right=getIslandId(grid,i,j+1);
        int current = getIslandId(grid,i,j);
        int min = Math.min(Math.min(Math.min(up,down),Math.min(left,right)),current);
        if(update(grid,i,j,min)||update(grid,i-1,j,min)||update(grid,i+1,j,min)||update(grid,i,j-1,min)||update(grid,i,j+1,min)){
            return true;
        }
        return false;
    }

    private boolean update(int[][] grid, int i, int j, int min) {
        if(i<0||i>=rowCount){
            return false;
        }
        if(j<0||j>=columnCount){
            return false;
        }
        if(grid[i][j]==Integer.MAX_VALUE){
            return false;
        }
        if(grid[i][j]>min){
            grid[i][j]=min;
            return true;
        }
        return false;
    }

    private int getIslandId(int[][] grid, int i, int j) {
        if(i<0||i>=rowCount){
            return Integer.MAX_VALUE;
        }
        if(j<0||j>=columnCount){
            return Integer.MAX_VALUE;
        }
        return grid[i][j];
    }
}
