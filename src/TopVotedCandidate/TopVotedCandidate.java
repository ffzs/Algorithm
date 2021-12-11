package TopVotedCandidate;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2021/12/11 上午7:38
 */
public class TopVotedCandidate {
    int[] persons, times, cnt, wins;
    int n, pCnt, cur, curI = 0;
    public TopVotedCandidate(int[] persons, int[] times) {
        n = persons.length;
        this.persons = persons;
        this.times = times;
        pCnt = 0;
        for (int person : persons) {
            pCnt = Math.max(person, pCnt);
        }
        cnt = new int[pCnt+1];
        wins = new int[n];
        cnt[persons[0]] = 1;
        wins[0] = persons[0];
        cur = times[0];
    }

    public int q(int t) {
        int i = 0;
        if (t > cur) {
            int win, max;
            i = curI + 1;
            System.out.println(i);
            win = wins[i-1];
            max = cnt[win];
            while (i < n && times[i] <= t) {
                cnt[persons[i]]++;
                System.out.println(Arrays.toString(cnt));
                if (cnt[persons[i]] >= max) {
                    win = persons[i];
                    max = cnt[win];
                }
                wins[i] = win;
                i++;
            }
            cur = t;
            curI = i - 1;
            return wins[i-1];
        }
        cur = Math.max(cur, t);
        i = getTime(t);
        return wins[i];
    }

    public int getTime(int findValue) {
        if (times == null) {
            return -1;
        }
        int start = 0;
        int end = times.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1 ;
            int middleValue = times[middle];
            if (findValue == middleValue) {
                return middle;
            } else if (findValue < middleValue) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start-1;
    }
}
