import java.util.ArrayList;
import java.util.List;

public class LC_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("",res, n, n);
        return res;
    }

    private void helper(String s, List<String> res, int left, int right) {
        if(right == 0) {
            res.add(s);
            return;
        }
        if(left > 0) {
            helper(s + "(", res, left - 1, right);
        }
        if(right > left) {
            helper(s + ")", res, left, right - 1);
        }
    }
}
