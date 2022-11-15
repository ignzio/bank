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

    public void remove(E element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) {
                    fastRemove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    fastRemove(i);
                    return;
                }
            }
        }
    }
    public void fastRemove(int index) {
        int movedNumber = this.size - index - 1;
        if (movedNumber > 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, movedNumber);
        }
        this.elements[--this.size] = null;
    }

    public E get(int index) {
        E e = this.elements[index];
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean isFull(){
        return size == elements.length -1;
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
