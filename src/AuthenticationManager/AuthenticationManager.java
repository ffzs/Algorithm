package AuthenticationManager;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/2/9 上午7:48
 */
public class AuthenticationManager {
    private int timeToLive, start;
    Map<String, Integer> tokens;
    List<String> ids = new ArrayList<>();
    List<Integer> times = new ArrayList<>();
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
        start = 0;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime);
        ids.add(tokenId);
        times.add(currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId)) {
            if (currentTime - tokens.get(tokenId) >= timeToLive) {
                tokens.remove(tokenId);
                return;
            }
            tokens.put(tokenId, currentTime);
            ids.add(tokenId);
            times.add(currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int i = start;
        for (; i < ids.size(); ++i) {
            int t = times.get(i);
            if (currentTime - t < timeToLive) break;
            String id = ids.get(i);
            if (tokens.getOrDefault(id, -1) == t) tokens.remove(id);
        }
        start = i;
        return tokens.size();
    }

}
