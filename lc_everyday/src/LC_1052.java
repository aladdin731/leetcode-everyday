public class LC_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        for (int i =0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }
        int left = 0, becomeSatisfied = 0, maxBecomeSatisfied = 0;
        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right] == 1) {
                becomeSatisfied += customers[right];
            }
            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    becomeSatisfied -= customers[left];
                }
                left++;
            }
            maxBecomeSatisfied = Math.max(maxBecomeSatisfied, becomeSatisfied);
        }
        return satisfied + maxBecomeSatisfied;
    }
}
