import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(candidates==null) return null;
    res = new ArrayList<>();
    dfs(candidates,target,new ArrayList<>(),0);
    return res;
    }
    private void dfs(int nums[],int target,List<Integer> temp,int index){
       if(target<0)return;
       else if(target==0) res.add(new ArrayList<>(temp));
       for(int i = index;i<nums.length;i++) {
           temp.add(nums[i]);
           dfs(nums,target-nums[i],temp,i);
            temp.remove(temp.size()-1);
       }
    }
}