import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
    res = new ArrayList<>();
    dfs(nums,new ArrayList<>(),0);
    return res;
    }
    private void dfs(int[] nums, List<Integer> temp, int index){
        if(nums.length<=index){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(nums,temp,index+1);
        temp.remove(temp.size()-1);
        dfs(nums,temp,index+1);
    }
}