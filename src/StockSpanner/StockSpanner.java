package StockSpanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/21 上午9:31
 */
public class StockSpanner {
    List<Integer> stock, below;
    public StockSpanner() {
        this.stock = new ArrayList<>();
        this.below = new ArrayList<>();
    }

    public int next(int price) {
        int idx = stock.size() - 1;
        while (idx >= 0) {
            if (price >= stock.get(idx)) idx = below.get(idx);
            else break;
        }
        stock.add(price);
        below.add(idx);
        return stock.size() - 1 - idx;
    }

}
