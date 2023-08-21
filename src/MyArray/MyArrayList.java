package MyArray;

/**
 * Класс реализует функциональность динамического списка на основе массива.
 * Поддерживает основные операции добавления, удаления, поиска элементов.
 * Элементы списка должны реализовывать интерфейс Comparable.
 * @version 0.1
 */

public class MyArrayList<T> {

    // Объявление внутреннего массива для хранения элементов
    /**
     * Внутренний массив для хранения элементов.
     */
    private T[] elements;

    /**
     * Текущий размер списка.
     */
    // Объявление поля для текущего размера списка
    private int size;

    // Начальная емкость списка
    private static final int INITIAL_CAPACITY = 10;


    // Конструктор - создание пустого списка с начальной емкостью
    public MyArrayList() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Добавление элемента в конец, увеличение размера
    /**
     * Добавляет элемент в конец списка.
     * Размер списка увеличивается на 1.
     * @param item добавляемый элемент
     */
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    /**
     * Вставляет элемент по указанному индексу.
     * Сдвигает остальные элементы вправо.
     * @param index индекс для вставки
     * @param item вставляемый элемент
     */
    // Вставка элемента по индексу со сдвигом элементов
    public void add(int index, T item) {
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    /**
     * Возвращает элемент по индексу.
     * @param index индекс элемента
     * @return элемент по заданному индексу
     */
    // Получение элемента по индексу с проверкой границ
    public T get(int index) {
        checkBounds(index);
        return elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Сдвигает остальные элементы влево.
     * @param index индекс удаляемого элемента
     */
    // Удаление элемента по индексу со сдвигом элементов
    public void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    /**
     * Возвращает текущий размер списка.
     * @return текущий размер
     */
    // Возвращение текущего размера списка
    public int size() {
        return size;
    }

    /**
     * Очищает список.
     * Обнуляет размер и создает новый пустой массив.
     */
    // Очистка списка - сброс размера и создание нового массива
    public void clear() {
        size = 0;
        elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Проверяет необходимость увеличения вместимости внутреннего массива.
     * Если требуемый размер больше текущего, создается новый больший массив.
     * @param capacity требуемая емкость
     */
    // Проверка необходимости увеличения емкости
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    /**
     * Проверяет, что индекс находится в допустимых границах.
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс выходит за границы
     */
    // Проверка границ индекса
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Сортировка элементов списка с использованием интерфейса Comparable
     * Сортирует элементы списка методом быстрой сортировки.
     *
     */
    public void sort() {
        quickSort(0, size - 1);
    }

    /**
     * Быстрая сортировка методом quicksort
     * @param low нижняя граница сортировки
     * @param high верхняя граница
     */
    private void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(low, high);
        quickSort(low, pivotIndex - 1);
        quickSort(pivotIndex + 1, high);
    }

    /**
     * Выполняет разделение подмассива в алгоритме quick sort.
     * @param low нижний индекс
     * @param high верхний индекс
     * @return индекс разделителя после перемещения
     */
    private int partition(int low, int high) {
        T pivot = elements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (((Comparable<T>) elements[j]).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами элементы в списке по индексам.
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}