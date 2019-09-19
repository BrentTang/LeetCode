package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brent
 * @title: CombinationSum
 * @projectName LeetCode
 * @date 2019/9/19 20:44
 * @description: 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void combination(int[] candidates, int target, int start, List<Integer> combi, List<List<Integer>> result) {
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(combi));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combi.add(candidates[i]);
            combination(candidates, target - candidates[i], i, combi, result);
            combi.remove(combi.size() - 1);
        }
    }

    /*public void combination(int[] candidates, int target,List<Integer> combi,int sum, List<List<Integer>> result) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(combi));
            return;
        }
        for (int candidate : candidates) {
            combi.add(candidate);
            combination(candidates, target, combi, sum + candidate, result);
            combi.remove(combi.size() - 1);
        }
    }*/

}
