package homework;

import homework.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 06/09/2023 Java Reflection API
 *
 * @author Wladimir Weizen
 */
public class SqlGenerator {

  public <T> String generateTable(Class<T> tableClass) {
    try {
      Constructor<T> constructor = tableClass.getConstructor();
      T tableClassObj = constructor.newInstance();
      String result = processAnnotations(tableClassObj);
      return String.format("CREATE TABLE %s (%s)", tableClass.getSimpleName(), result);
    } catch (ReflectiveOperationException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private <T> String processAnnotations(T object) {
    StringBuilder result = new StringBuilder();
    Class<T> aClass = (Class<T>) object.getClass();
    Field[] fields = aClass.getDeclaredFields();

    for (Field field : fields) {
      StringBuilder fieldResult = new StringBuilder();
      Annotation[] annotations = field.getDeclaredAnnotations();
      if (annotations.length != 0) {
        fieldResult.append(field.getName());
        for (Annotation annotation : annotations) {
          String value = generateString(field, annotation.annotationType());
          fieldResult.append(value);
        }
      } else {
        throw new NullPointerException("could not prepare statement");
      }
      if (result.isEmpty()) {
        result.append(fieldResult);
      } else {
        result.append(", ").append(fieldResult);
      }
    }
    return result.toString();
  }

  private String generateString(Field field, Class<?> annotationType) {
    String result = "";

    if (annotationType.equals(Varchar.class)) {
      Varchar varchar = field.getDeclaredAnnotation(Varchar.class);
      result = " " + Varchar.value + "(" + varchar.maxLength() + ")";
    }
    if (annotationType.equals(Int.class)) {
      result = " INT";
    }
    if (annotationType.equals(PrimaryKey.class)) {
      result = " " + PrimaryKey.value;
    }
    if (annotationType.equals(Unique.class)) {
      result = " " + Unique.value;
    }
    if (annotationType.equals(NotNull.class)) {
      result = " " + NotNull.value;
    }
    return result;
  }
}
