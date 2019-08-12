package easy;

/**
 * @author Brent
 * @title: ImplementstrStr
 * @projectName LeetCode
 * @date 2019/8/12 18:34
 * @description: 28. 实现 strStr()
 *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *  示例 1:
 *      输入: haystack = "hello", needle = "ll"
 *      输出: 2
 *  示例 2:
 *      输入: haystack = "aaaaa", needle = "bba"
 *      输出: -1
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() < 1) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int cur = 0;
            while (cur < needle.length() && cur + i < haystack.length() && haystack.charAt(i + cur) == needle.charAt(cur++)) ;
            if (cur-- == needle.length() && haystack.charAt(i + cur) == needle.charAt(cur)) {
                return i;
            }
        }
        return -1;
    }

}
