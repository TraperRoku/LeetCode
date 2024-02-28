import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    dfs(nums,new ArrayList<>());
    return res;
    }
    private void dfs(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs(nums,temp);
            temp.remove(temp.size()-1);
        }

    }
}