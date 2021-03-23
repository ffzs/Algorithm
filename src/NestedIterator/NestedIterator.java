package NestedIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/3/23 下午5:46
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }
    
    private void dfs (List<NestedInteger> list) {
        for (NestedInteger nest : list) {
            if (nest.isInteger()) vals.add(nest.getInteger());
            else dfs(nest.getList());
        }
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

}
