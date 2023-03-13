package minNumberOfHours;

/**
 * @author: ffzs
 * @Date: 2023/3/13 上午8:07
 */
public class Solution {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int total = 0, diff = 0, exp = initialExperience;
        for (int i : energy) {
            total += i;
        }

        for (int i : experience) {
            diff = Math.max(diff, i + 1 - exp);
            exp += i;
        }

        return Math.max(0, total + 1 - initialEnergy) + diff;
    }

}
