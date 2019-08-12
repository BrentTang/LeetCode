package medium;

import org.junit.Test;

/**
 * @author Brent
 * @title: DivideTwoIntegers
 * @projectName LeetCode
 * @date 2019/8/12 20:16
 * @description: 29. 两数相除
 *  给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *  返回被除数 dividend 除以除数 divisor 得到的商。
 *  示例 1:
 *      输入: dividend = 10, divisor = 3
 *      输出: 3
 *  示例 2:
 *      输入: dividend = 7, divisor = -3
 *      输出: -2
 *  说明:
 *      * 被除数和除数均为 32 位有符号整数。
 *      * 除数不为 0。
 *      * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 *        本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers {

    /**
     * 1. 符号
     * 2. 越界
     * 3. 为0
     * 4. 正常
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 为0
        if (dividend ==0) return 0;
        else if (divisor == 0) return -1;
        boolean sign = true;
        // 符号
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = false;
        // 防止越界
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        if (longDividend < longDivisor) return 0;

        long mul = divide(longDividend, longDivisor);
        if (mul > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign ? (int) mul : (int) (~mul + 1);
        }
    }

    public long divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long mul = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            mul += mul;
        }
        return mul + divide(dividend - sum, divisor);
    }

}
