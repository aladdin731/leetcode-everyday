public class LC_856 {
    public int scoreOfParentheses(String s) {
        int res = 0;
        int depth = 1;
        for (int i = 0; i < s.length() - 1;) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                res += depth;
                i += 2;
            } else if (s.charAt(i) == '(') {
                depth *= 2;
                i++;
            } else {
                depth /= 2;
                i++;
            }
        }
        return res;
    }
}