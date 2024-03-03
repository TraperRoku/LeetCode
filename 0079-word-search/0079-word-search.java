class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, 0,n,m, word)) return true;
            }
        }
            return false;

    }
    private boolean dfs(char[][] board, int i, int j, int count,int n,int m, String word){
    if(count >= word.length()) return true;
    if( i < 0 || j<0|| i>= n|| j >= m|| board[i][j] != word.charAt(count)) return false;
    boolean exist = false;

    if(board[i][j] == word.charAt(count)){
        board[i][j] += 100;
        exist = dfs(board,i+1,j,count+1,n,m,word) ||
                dfs(board,i,j+1,count+1,n,m,word) ||
                dfs(board,i-1,j,count+1,n,m,word) ||
                dfs(board,i,j-1,count+1,n,m,word);
                board[i][j] -= 100;
    }
    return exist;
    }

}