import java.util.ArrayList;
import java.util.List;

public class LC_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S.length() == 0 || S == null) return res;
        helper(res, S, "");
        return res;
    }

    private void helper(List<String> res, String S, String temp) {
        if(temp.length() == S.length()) {
            res.add(temp);
            return;
        }
        char cur = S.charAt(temp.length());
        if(Character.isLetter(cur)) {
            helper(res, S, temp + Character.toUpperCase(cur));
            helper(res, S, temp + Character.toLowerCase(cur));
        }else {
            helper(res, S, temp + cur);
        }
    }
}
