  public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        String[] res = new String[nums.length];
        // num -> string 
        for(int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        // 
        Arrays.sort(res, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            // if s2 > s1 return 1 从大到小排
            return s2.compareTo(s1);
        });
            
        if(res[0].equals("0")) return "0";
        
        // StringBuilder -> String
        StringBuilder sb = new StringBuilder();
        for(String s : res) sb.append(s);
        
        return sb.toString();
    }