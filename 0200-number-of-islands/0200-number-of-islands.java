class Solution {

    public int numIslands(char[][] grid) {

        int wiersze = grid.length;
        int col = grid[0].length;
        int sum = 0;
        boolean[][] visited = new boolean[wiersze][col];
      for(int i = 0; i < wiersze; i ++){
          for(int j = 0; j < col; j++){
              if(grid[i][j] == '1'){
                  helper(visited,i,j,grid,wiersze , col);
                  sum+=1;

              }
          }
      }

    return sum;
    }
    public void helper(boolean[][] visited, int i, int j, char[][] grid, int wiersze, int col) {
            if (i >= 0 && j>=0 &&  wiersze > i && col > j && visited[i][j] == false && grid[i][j] == '1') {
                grid[i][j] = '0';
                visited[i][j] = true;
                    helper(visited, i + 1, j, grid, wiersze, col);
                    helper(visited, i - 1, j, grid, wiersze, col);
                    helper(visited, i, j + 1, grid, wiersze, col);
                    helper(visited, i, j - 1, grid, wiersze, col);

            }
        }
    }


