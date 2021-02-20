import java.util.ArrayList;
import java.util.List;

public class LC_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0) return res;
        helper(res, s, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<String>> res, String s, List<String> temp, int low) {
        int len = s.length();
        if(low == len) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int high = low; high < len; high++) {
            String sub = s.substring(low, high + 1);
            if(isPal(sub)) {
                temp.add(sub);
                helper(res, s, temp, high + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPal(String s) {
        int len = s.length();
        if(len == 1) return true;
        for(int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
