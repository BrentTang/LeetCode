package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.spi.CalendarNameProvider;

/**
 * @author Brent
 * @title: CombinationSum2
 * @projectName LeetCode
 * @date 2019/9/19 22:21
 * @description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 *  示例 1:
 *   输入: candidates = [10,1,2,7,6,1,5], target = 8,
 *   所求解集为:
 *   [
 *     [1, 7],
 *     [1, 2, 5],
 *     [2, 6],
 *     [1, 1, 6]
 *   ]
 *
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> combi, List<List<Integer>> result) {
        if (target < 0)
            return ;
        if (target == 0) {
            result.add(new ArrayList<>(combi));
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i])
                continue;
            combi.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combi, result);
            combi.remove(combi.size() - 1);
        }
    }

}
