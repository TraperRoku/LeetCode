import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2
            (int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(new ArrayList<>(), 0,target , candidates);
        return res;
    }

    private void dfs(List<Integer> temp,int index, int target, int[] cand){
        if(target == 0) res.add(new ArrayList<>(temp));
        if(target < 0) return;

        int prev = -1;
        for(int i = index; i < cand.length; i++){
            if(cand[i] == prev) continue;

            if(cand[i]> target )return;
            temp.add(cand[i]);

            dfs(temp,i+1,target-cand[i],cand);
            temp.remove(temp.size()-1);
            prev = cand[i];
        }
    }
}