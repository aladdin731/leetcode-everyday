

public class LC_526 {
    int count = 0;
    public int countArrangement(int n) {
        if(n == 0) return 0;
        helper(n, 1, new boolean[n + 1]);
        return count;
    }

    private void helper(int n, int pos, boolean[] used) {
        if(pos == n + 1) {
            count++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                helper(n, pos + 1, used);
                used[i] = false;
            }
        }
    }
}
