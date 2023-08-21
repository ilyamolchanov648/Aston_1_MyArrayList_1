
package Test;

import MyArray.MyArrayList; // Импорт класса MyArrayList из пакета MyArray
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Класс для тестирования методов класса MyArrayList.
 */
public class MyArrayListTest {

    /**
     * Тест: добавление элемента.
     */
    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        Assert.assertEquals(1, list.size());
        assertEquals(1, (int)list.get(0));
    }

    /**
     * Тест: добавление элемента по индексу.
     */
    @Test
    public void testAddByIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 42);
        Assert.assertEquals(1, list.size());
        assertEquals(42, (int)list.get(0));
    }

    /**
     * Тест: удаление элемента.
     */
    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        Assert.assertEquals(1, list.size());
        assertEquals(2, (int)list.get(0));
    }

    /**
     * Тест: сортировка списка.
     */
    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort();
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
        assertEquals(3, (int)list.get(2));
    }

    /**
     * Тест: размер пустого списка.
     */
    @Test
    public void testSizeEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();// Создание пустого списка
        assertEquals(0, list.size());// Проверка, что размер списка равен ожидаемому значению (0)
    }

    /**
     * Тест: размер списка после добавления элементов.
     */
    @Test
    public void testSizeAfterAdd() {
        MyArrayList<String> list = new MyArrayList<>();// Создание списка строк
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals(3, list.size());// Проверка, что размер списка равен ожидаемому значению (3)
    }

    /**
     * Тест: размер списка после добавления и удаления элементов.
     */
    @Test
    public void testSizeAfterAddAndRemove() {
        MyArrayList<Double> list = new MyArrayList<>();// Создание списка чисел с плавающей точкой
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.remove(1);// Удаление второго элемента
        assertEquals(2, list.size()); // Проверка, что размер списка равен ожидаемому значению (2)
    }

    /**
     * Тест для проверки функциональности MyArrayList с элементами разных типов данных.
     */
    @Test
    public void testMixedTypes() {
        MyArrayList<Object> mixedList = new MyArrayList<>();

        mixedList.add("Hello"); // Добавляем строку
        mixedList.add(42); // Добавляем целое число
        mixedList.add(3.14); // Добавляем дробное число
        mixedList.add(true); // Добавляем логическое значение

        // Проверка размера списка
        assertEquals(4, mixedList.size());

        // Проверка элементов
        assertEquals("Hello", mixedList.get(0));
        assertEquals(42, mixedList.get(1));
        assertEquals(3.14, (double) mixedList.get(2), 0.001); // Указываем погрешность для сравнения дробных чисел
        assertEquals(true, mixedList.get(3));
    }


}
