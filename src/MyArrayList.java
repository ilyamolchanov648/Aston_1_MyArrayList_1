class MyArrayList<T> {

    // Объявление внутреннего массива для хранения элементов
    private T[] elements;

    // Объявление поля для текущего размера списка
    private int size;


    // Конструктор - создание пустого списка с начальной емкостью 10
    public MyArrayList() {
        elements = (T[])new Object[10];
    }



    // Добавление элемента в конец, увеличение размера
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }
    // Вставка элемента по индексу со сдвигом элементов
    public void add(int index, T item) {
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    // Получение элемента по индексу с проверкой границ
    public T get(int index) {
        checkBounds(index);
        return elements[index];
    }

    // Удаление элемента по индексу со сдвигом элементов
    public void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    // Возвращение текущего размера списка
    public int size() {
        return size;
    }

    // Очистка списка - сброс размера и создание нового массива
    public void clear() {
        size = 0;
        elements = (T[])new Object[10];
    }

    // Проверка необходимости увеличения емкости
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            // создание большего массива и копирование данных
            T[] newElements = (T[])new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Проверка границ индекса
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

}