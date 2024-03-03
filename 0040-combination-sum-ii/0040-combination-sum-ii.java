import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    result = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates,target,new ArrayList<>(),0);
    return result;
    }
    private void dfs(int[] candidates, int target, List<Integer> temp, int start){
        if(target < 0) return;
        if(target == 0) result.add(new ArrayList<>(temp));

        for(int i = start; i < candidates.length; i++){
            if( i > start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            dfs(candidates,target-candidates[i],temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}