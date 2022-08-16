package OrderedStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/8/16 上午11:32
 */
public class OrderedStream {

    private String[] vals;
    private int ptr;
    public OrderedStream(int n) {
        vals = new String[n + 1];
        ptr = 1;
    }
    public List<String> insert(int idKey, String value) {
        List<String> ret = new ArrayList<>();
        vals[idKey] = value;
        if (idKey == ptr){
            while (ptr < vals.length && vals[ptr] != null) {
                ret.add(vals[ptr++]);
            }
        }
        return ret;
    }
}
