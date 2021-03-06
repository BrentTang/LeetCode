package medium;

import org.junit.Test;

/**
 * @author Brent
 * @title: MultiplyStrings
 * @projectName LeetCode
 * @date 2019/9/20 14:06
 * @description: 43. 字符串相乘
 *  给定两个以字符串形式表示的非负整数 num1 和 num2，
 *  返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 *  示例 1:
 *   输入: num1 = "2", num2 = "3"
 *   输出: "6"
 *  示例 2:
 *   输入: num1 = "123", num2 = "456"
 *   输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";

        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int before = i + j, after = before + 1;
                temp += digits[after];
                digits[before] += temp / 10;
                digits[after] = temp % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int d : digits) {
            if (!(d == 0 && sb.length() == 0))
                sb.append(d);
        }

        return sb.toString();
    }

    @Test
    public void test() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

}
