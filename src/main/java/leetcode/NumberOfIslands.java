package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 8/2/15.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int numberIslands = 0;
        if (grid != null && grid.length > 0 && grid[0].length > 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, grid);
                        numberIslands++;
                    }
                }
            }
        }
        return numberIslands;
    }

    //depth first search non recursive
    private void dfs(int i, int j, char[][] grid) {
        Stack<int[]> stack = new Stack();
        stack.add(new int[]{i,j});
        while(!stack.isEmpty()){
            int[] tmp = stack.pop();
            i=tmp[0];
            j=tmp[1];
            if ('0' == grid[i][j]) return;
            grid[i][j] = '0';
            if (i - 1 > -1) dfs(i - 1, j, grid);
            if (i + 1 < grid.length) dfs(i + 1, j, grid);
            if (j - 1 > -1) dfs(i, j - 1, grid);
            if (j + 1 < grid[0].length) dfs(i, j + 1, grid);
        }

    }

    private void dfs_recursive(int i, int j, char[][] grid) {
        if ('0' == grid[i][j]) return;
        grid[i][j] = '0';
        if (i - 1 > -1) dfs(i - 1, j, grid);
        if (i + 1 < grid.length) dfs(i + 1, j, grid);
        if (j - 1 > -1) dfs(i, j - 1, grid);
        if (j + 1 < grid[0].length) dfs(i, j + 1, grid);
    }

    int[] directions = {0, 1, 0, -1, 0};

    //breath first search
    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> front = new ArrayDeque<int[]>();//can use depth first search instead
        grid[i][j] = '0';
        front.add(new int[]{i, j});
        while (!front.isEmpty()) {
            int[] tmp = front.poll();
            for (int d = 0; d < directions.length - 1; d++) {
                int x = tmp[0] + directions[d], y = tmp[1] + directions[d + 1];
                if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == '1') {
                    front.add(new int[]{x, y});
                    grid[x][y] = '0';
                }
            }
        }
    }

    /*
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

    */


    /**
     *
     * @param grid
     * @param i
     * @param j
     * @return true if value got updated
     */
     /*
    private boolean updateMinimumAround(int[][] grid, int i, int j) {
        int up=getIslandId(grid,i-1,j);
        int down=getIslandId(grid,i+1,j);
        int left=getIslandId(grid,i,j-1);
        int right=getIslandId(grid,i,j+1);
        int current = getIslandId(grid,i,j);
        int min = Math.min(Math.min(up,down),Math.min(left,right));
        if(current>min){
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
    */
}
