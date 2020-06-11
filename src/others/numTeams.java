package others;

public class numTeams {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i=1; i<rating.length-1; i++) {
            int left_more = 0 , left_less = 0, right_more=0, right_less=0;
            for (int j=0; j<i; j++){
                if (rating[j]<rating[i]) left_less++;
                else if (rating[j]>rating[i]) left_more++;
            }
            for (int k=i+1; k<rating.length; k++){
                if (rating[i] < rating[k]) right_more++;
                else if (rating[i] > rating[k]) right_less++;
            }
            count += left_less*right_more + left_more*right_less;
        }
        return count;
    }
}
