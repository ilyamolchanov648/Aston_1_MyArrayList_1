package Main;
import MyArray.MyArrayList;
public class Main {

    public static void main(String[] args) {

        //Эта строка инициализирует новый объект списка, который в дальнейшем будет использоваться
         MyArrayList<Integer> list = new MyArrayList<>();

        // Добавление элементов
        list.add(1);
        list.add(2);
        list.add(3);

        // Вставка элемента по индексу
        list.add(1, 4);

        // Получение элемента по индексу
        System.out.println(list.get(2));

        // Удаление элемента
        list.remove(2);

        // Проверка размера
        System.out.println(list.size());

        // Очистка списка
        list.clear();
        System.out.println(list.size());

    }

}

