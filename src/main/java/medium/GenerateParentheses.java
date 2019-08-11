package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brent
 * @title: GenerateParentheses
 * @projectName LeetCode
 * @description: 22. 括号生成
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 *  例如，给出 n = 3，生成结果为：
 *      [
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @date 2019/8/11 22:39
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        // back track
        generate("", n, n, res);
        return res;
    }

    public void generate(String s, int left, int right, List<String> res) {
        // (()))  5pairs left:3 right:2
        if (left > right) return;
        // 左右括号使用完了
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        // 还有左括号可以使用
        if (left > 0) {
            generate(s + "(", left - 1, right, res);
        }
        // 还有右括号可以使用
        if (right > 0) {
            generate(s + ")", left, right - 1, res);
        }
    }

}
