package countStudents;

/**
 * @author: ffzs
 * @Date: 2022/10/19 下午8:02
 */
public class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int likes = 0, dislikes = 0;
        for (int student : students) {
            if (student == 0) dislikes += 1;
            else likes += 1;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) dislikes -= 1;
            else likes -= 1;
            if (dislikes < 0 || likes < 0) return likes + dislikes + 1;
        }
        return 0;
    }

}
