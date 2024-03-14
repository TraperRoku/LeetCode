class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {

         int row = board.length;
         int col = board[0].length;
         visited = new boolean[row][col];

         for(int i = 0; i < row; i++){
             for(int j = 0; j < col; j++){
            if(dfs(board,i,j,0,word)){
                return true;
            }
             }
         }
         return false;
    }
    private boolean dfs(char[][] board, int row, int col, int index, String word){
        if(row == -1 || col == -1 || row == board.length || col == board[0].length){
            return false;
        }
        if(visited[row][col] || board[row][col] != word.charAt(index)) return false;

        visited[row][col] = true;

        if(word.length() - 1 == index) return true;

        index++;

        if(dfs(board,row+1,col,index,word) ||
        dfs(board,row-1,col,index,word) ||
        dfs(board,row,col -1 ,index, word) ||
        dfs(board,row, col + 1, index, word)){
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}