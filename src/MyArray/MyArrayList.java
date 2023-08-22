package MyArray;
import java.util.Comparator;

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

    /**
     * Сортировка элементов списка с использованием компаратора.
     * Сортирует элементы списка методом быстрой сортировки.
     *
     * @param comparator компаратор для сравнения элементов
     */
    public void sort(Comparator<? super T> comparator) {
        quickSortWithComparator(0, size - 1, comparator);
    }

    /**
     * Быстрая сортировка методом quicksort с использованием компаратора.
     *
     * @param low        нижняя граница сортировки
     * @param high       верхняя граница
     * @param comparator компаратор для сравнения элементов
     */
    private void quickSortWithComparator(int low, int high, Comparator<? super T> comparator) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partitionWithComparator(low, high, comparator);
        quickSortWithComparator(low, pivotIndex - 1, comparator);
        quickSortWithComparator(pivotIndex + 1, high, comparator);
    }

    /**
     * Выполняет разделение подмассива в алгоритме quick sort с использованием компаратора.
     *
     * @param low        нижний индекс
     * @param high       верхний индекс
     * @param comparator компаратор для сравнения элементов
     * @return индекс разделителя после перемещения
     */
    private int partitionWithComparator(int low, int high, Comparator<? super T> comparator) {
        T pivot = elements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}