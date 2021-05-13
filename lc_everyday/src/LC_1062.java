public class LC_1062 {
    public int longestRepeatingSubstring(String S) {
        // length of the logest repeating substring [0,n)
        // verify if length x is a valid answer
        int left = 0;
        int right = S.length() - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(S, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public boolean isValid(String s, int length) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
            int j = i + length - 1;
            String sub = s.substring(i, j + 1);
            if (seen.contains(sub)) {
                return true;
            }
            seen.add(sub);
        }
        return false;
    }
    
}
