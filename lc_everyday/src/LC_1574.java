public class LC_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        // 分三段
        // [x x x x] [x x x] [x x]
        //        i           j
        // arr[i] <= arr[j]
        // (0,i)(j,n-1) 单增
        // 要删除的越短 前后面单增的越大
        int n = arr.length;
        int res = n - 1;
        // 从后往前最长的递增区间
        int j = n - 1;
        while(j - 1 >= 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        res = Math.min(res, j);
        // 整个array都是递增的
        if(res == 0) return 0;

        for(int i = 0; i < n; i++) {
            // 若不是单增的 则停止循环
            if(i - 1 >= 0 && arr[i - 1] > arr[i]){
                break;
            }
            while(j < n && arr[j] < arr[i]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
        }
        return res;
    }
}
