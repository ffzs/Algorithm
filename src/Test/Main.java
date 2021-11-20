package Test;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        String s = "nwlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgwpbtrwblnsadeuguumoqcdrubetokyxhoachwdvmxxrdryxlmndqtukwagmlejuukwcibxubumenmeyatdrmydiajxloghiqfmzhlvihjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhiixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbfcriqifpgynkrrefxsnvucftpwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwl";
//        System.out.println(s.substring(0,0));
//        System.out.println(solve(s));
        System.out.println(maxLength(new int[] {1,2,3,4,1,5,6,7,8,1}));
    }


    private static String add(String a, String b) {
        StringBuilder x = new StringBuilder(a).reverse();
        StringBuilder y = new StringBuilder(b).reverse();
        StringBuilder ret = new StringBuilder();

        int n = Math.max(x.length(), y.length());
        int p = 0;
        for (int i = 0; i < n; i++) {
            int vx = i < x.length() ? x.charAt(i) - '0': 0;
            int vy = i < y.length() ? y.charAt(i) - '0': 0;
            int sum = vx + vy + p;
            ret.append(sum%10);
            p = sum / 10;
        }
        if (p != 0) ret.append(p);
        return ret.reverse().toString();
    }

    public static int solve (String a) {
        // write code here
        int n = a.length();

        if (n <= 1) return 0;
        int res = 0;
        for (int j = 1; j < n - 1; j++) {
            for (int i = 0; i < j; i++) {
                 if ((j - i + 1) % 2 != 0) continue;
                 int mid = (i + j + 1) >>> 1;
                 if (a.substring(i, mid).equals(a.substring(mid, j + 1))) {
                     int len = helper(a, i, mid - i);
                     res = Math.max(res, len);
                 }
            }
        }
        return res;
    }

    private static int helper (String a, int start, int len) {
        int cnt = 2;
        for (int i = start + 2 * len; i < a.length(); i += len) {
            if (i + len < a.length() && a.substring(start, start + len).equals(a.substring(i, i + len))) cnt++;
            else break;
        }
        return len * cnt;
    }

    public static int maxLength (int[] arr) {
        // write code here

        int l = 0, r, res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (r = 0; r < arr.length; r++) {
            if (map.containsKey(arr[r])) {
                l = Math.max(l, map.get(arr[r]) + 1);
            }
            map.put(arr[r], r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
