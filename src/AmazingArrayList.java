import java.util.Arrays;
import java.util.Iterator;

public class AmazingArrayList<E> implements Iterable<E> {

    private E[] elements;
    private int size;
    public AmazingArrayList() {
        this(10);
    }

    public AmazingArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("illegal size:" + initSize);
        }
        this.elements = (E[]) new Object[initSize];
    }

    public int size() {
        return this.size;
    }


    private void ensureCapacity(int needCapacity) {
        if (needCapacity > elements.length) {
            Object[] oldElements = this.elements;
            int newSize = this.size * 2 + 1;
            this.elements = (E[]) new Object[newSize];
            this.elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    
    public boolean add(E element) {
        ensureCapacity(this.size + 1);
        elements[this.size++] = element;
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new AmazingListIterator<>();
    }
    private class AmazingListIterator<E> implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return this.current < size();
        }

        @Override
        public E next() {
            E value = (E) elements[current++];
            return value;
        }
    }
}
