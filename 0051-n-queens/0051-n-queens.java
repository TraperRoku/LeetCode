import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>(); // r+c
    HashSet<Integer> negDiag = new HashSet<>(); // r-c

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        backtracking(res,0,n,new ArrayList<>());

        return res;
    }
    private void backtracking(List<List<String>> res , int row, int n, List<String> list){
        if(row == n) res.add(new ArrayList<>(list));
        else {
            for(int i = 0; i < n; i++){
                if(col.contains(i) || posDiag.contains(row + i) || negDiag.contains(row - i)) continue;

                char[] charArr = new char[n];
                Arrays.fill(charArr,'.');

                charArr[i] = 'Q';
                String stringChar = new String(charArr);

                list.add(stringChar);

                col.add(i);
                posDiag.add(row+i);
                negDiag.add(row-i);

                backtracking(res,row+1,n,list);



                list.remove(list.size()-1);
                col.remove(i);
                posDiag.remove(row+i);
                negDiag.remove(row-i);

            }
        }
    }
}