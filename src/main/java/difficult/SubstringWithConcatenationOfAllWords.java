package difficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brent
 * @title: SubstringWithConcatenationOfAllWords
 * @projectName LeetCode
 * @date 2019/8/13 10:12
 * @description: 30. 串联所有单词的子串
 *  给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *  注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *  示例 1：
 *      输入：
 *          s = "barfoothefoobarman",
 *          words = ["foo","bar"]
 *      输出：[0,9]
 *      解释：
 *          从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 *          输出的顺序不重要, [9,0] 也是有效答案。
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;

        int wordsLen = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordsLen * wordLen; i++) {
            Map<String, Integer> record = new HashMap<>(map);
            int count = wordsLen;
            int start = i;
            while (count > 0) {
                String str = s.substring(start, start + wordLen);
                if (!record.containsKey(str) || record.get(str) < 1) break;
                record.put(str, record.get(str) - 1);
                count--;
                start += wordLen;
            }

            if (count == 0) res.add(i);
        }
        return res;
    }

}
