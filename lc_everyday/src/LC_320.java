import java.util.ArrayList;
import java.util.List;

public class LC_320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, word);
        return res;
    }
    
    private void helper(List<String> res, String s, int index, int count, String word) {
        if(index == word.length()) {
            if(count > 0) {
                s += count;
            }
            res.add(s);
            return;
        }
        helper(res, s, index + 1, count + 1, word);
        s = s + (count > 0? count : "") + word.charAt(index);
        helper(res, s, index + 1, 0, word);
    }
}