package firstBadVersion;

/**
 * @author: ffzs
 * @Date: 2021/6/13 上午10:13
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    public boolean isBadVersion(int version) {
        return true;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
