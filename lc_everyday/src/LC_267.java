import java.util.ArrayList;
import java.util.List;

public class LC_267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder("");
        char[] count = new char[256];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++) {
            if(count[i] % 2 != 0) {
                sb.append((char) i);
            }
        }
        if(sb.length() > 1) return res;

        helper(res, s, sb, count);
        return res;
    }

    private void helper(List<String> res, String s, StringBuilder temp, char[] count){
        if(temp.length() == s.length()){
            res.add(temp.toString());
            return;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] >= 2) {
                count[i] -= 2;
                temp.insert(0, (char) i);
                temp.append((char) i);
                helper(res, s, temp, count);
                temp.deleteCharAt(temp.length() - 1);
                temp.deleteCharAt(0);
                count[i] += 2;
            }
        }
    }
}
