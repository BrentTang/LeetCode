package easy;

import java.util.Stack;

/**
 * @author Brent
 * @title: ValidParentheses
 * @projectName LeetCode
 * @description: 20. 有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *  注意空字符串可被认为是有效字符串。
 * @date 2019/8/11 17:34
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() < 0) return true;
        else if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (getRight(c) == ' ') {
            // 右括号
                if (stack.empty()) return false;
                if (getRight(stack.pop()) != c)
                    return false;
            } else {
            // 左括号
                stack.push(c);
            }
        }

        return stack.empty() ? true:false;
    }

    public char getRight(char left) {
        switch (left) {
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
            default: return ' ';
        }
    }

}
