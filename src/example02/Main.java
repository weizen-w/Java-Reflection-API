package example02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String className = scanner.nextLine();

        Class<?> aClass = Class.forName(className); // получаем объект типа Class для класса с названием className

        Constructor<?> constructor = aClass.getConstructor(String.class, int.class); // у этого класса запрашиваем конструктор с двумя параметрами
        // PasswordValidator validator = new PasswordValidator(...)
        Object object = constructor.newInstance("Hello!", 2); // создаем экземпляр этого класса,
        // передавая в полученный конструктор два конкретных аргумента

        Field field = aClass.getDeclaredField("minLength"); // получаем приватное поле класса
        field.setAccessible(true); // делаем его доступным
        field.set(object, 150); // у экземпляра object делаем значение поля field равным 150

        Method method = aClass.getDeclaredMethod("validate", String.class); // получаем метод по названию и его параметрам
        Object result = method.invoke(object, "qwerty007"); // вызываем метод method у object-а с аргументом

        System.out.println(result); // печатаем результат вызова метода
    }
}
