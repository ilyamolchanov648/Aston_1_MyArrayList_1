class MyArrayList<T> {

    private T[] elements;
    private int size;

    public MyArrayList() {
        elements = (T[])new Object[10];
    }

    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    public void add(int index, T item) {
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    public T get(int index) {
        checkBounds(index);
        return elements[index];
    }

    public void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }
    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        elements = (T[])new Object[10];
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            T[] newElements = (T[])new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

}