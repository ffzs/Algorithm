package PeekingIterator;

import java.util.Iterator;

/**
 * @author: ffzs
 * @Date: 2021/10/5 上午7:02
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        next = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = next;
        next = it.hasNext()? it.next(): null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
