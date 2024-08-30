class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new ArrayList<Integer>(), result, 0);
        return result;
    }
    public void combinationSum2(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int start){
        if(target == 0)
            result.add(new ArrayList<Integer>(list));
        else if(target < 0)
            return;
        else{
            int pre = -1;
            for(int i = start; i < candidates.length; i++){
                if(pre == -1)
                    pre = candidates[i];
                else if(candidates[i] == pre)
                    continue;
                else    pre = candidates[i];
                list.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], list, result, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}