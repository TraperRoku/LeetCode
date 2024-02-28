import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
    res = new ArrayList<>();
    dfs(nums,0,new ArrayList<>());
    return res;
    }
    private void dfs(int[]nums,int index,List<Integer>temp){

        res.add(new ArrayList<>(temp));

        for(int i = index; i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            dfs(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}