package example03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class ObjectCreator {

    public <T> T create(Class<T> aClass) {
        try {
            Constructor<T> constructor = aClass.getConstructor(); // получаем пустой конструктор для произвольного класса

            T result = constructor.newInstance(); // создаю экземпляр класса

            processAnnotations(result); // обработка аннотации DefaultValue

            return result;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private <T> void processAnnotations(T object) {
        Class<T> aClass = (Class<T>) object.getClass(); // получаем класс исходного объекта

        Field[] fields = aClass.getDeclaredFields(); // получили все поля

        // нужно выбрать те поля, у которых стоит аннотация DefaultValue
        for (Field field : fields) {
            DefaultValue defaultValue = field.getDeclaredAnnotation(DefaultValue.class); // получаем аннотацию над полем, если она есть

            if (defaultValue != null) { // если аннотация над полем есть
                String valueString = defaultValue.value(); // получаем для текущего поля значение, которое лежит в виде строки
                Class<?> fieldType = field.getType(); // получаем тип поля

                Object value = getTypedValue(valueString, fieldType);

                field.setAccessible(true); // делаем поле доступным
                try {
                    field.set(object, value); // задаем значение этого поля, взятое из аннотации
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }

    private Object getTypedValue(String arg, Class<?> fieldType) {
        Object value = null;

        if (fieldType.equals(String.class)) {
            return arg;
        } else if (fieldType.equals(Integer.TYPE)) { // если поле int - преобразуем строку в int
            value = Integer.parseInt(arg);
        } else if (fieldType.equals(Double.TYPE)) { // если поле double - преобразуем строку в double
            value = Double.parseDouble(arg);
        } else if (fieldType.equals(LocalDate.class)) {
            value = LocalDate.parse(arg);
        }

        return value;
    }
}
