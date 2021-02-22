import java.util.ArrayList;
import java.util.List;

public class LC_17 {
    String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        // 从digit的index 0 的位置起 是因为需要对应map
        // 因为涉及到改变string 所以最好stringbuilder
        StringBuilder temp = new StringBuilder("");
        helper(res, digits, temp);
        return res;
    }
    public void helper(List<String> res, String digits, StringBuilder temp) {
        if (temp.length() == digits.length()) { // 要最后的结果 所以有条件才添加
            res.add(temp.toString()); // 这里不需要深拷贝是因为上一步并没有改变上一步的temp 
            return;
        }
        String letters = map[digits.charAt(temp.length()) - '0'];
        // 每一堆字母都需要循环 
        for(int i = 0; i < letters.length(); i++) {
            // 然后进入下一堆 index + 1
            // 这里只所以不需要回溯是因为 并没有改变temp 如果temp是stringbuilder则需要回溯
            temp.append(letters.charAt(i));
            helper(res, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}