package defangIPaddr;

    /**
     * @author: ffzs
     * @Date: 2022/6/21 下午6:20
     */
    public class Solution {

        public String defangIPaddr(String address) {

            StringBuilder sb = new StringBuilder();
            for (char c : address.toCharArray()) {
                if (c == '.') sb.append("[.]");
                else sb.append(c);
            }
            return sb.toString();
        }

    }
