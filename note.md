String

String.valueOf(xx) 将其他格式转化为string格式
Arrays.sort(res, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            // if s2 > s1 return 1 从大到小排
            return s2.compareTo(s1);
        });

StringBuilder -> String 
StringBuilder sb = new StringBuilder();
sb.append("xx")
sb.toString()

