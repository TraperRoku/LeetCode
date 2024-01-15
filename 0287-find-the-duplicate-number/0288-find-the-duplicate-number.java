public int findDuplicate(int[] nums) {
    int n = nums.length-1;
    HashMap<Integer,Integer> map = new HashMap<>();
    while (n !=-1){
        map.put(nums[n],map.getOrDefault(nums[n],0)+1);
        if(map.get(nums[n])==2) return nums[n];
        n--;
    }
    return -1;
    }
