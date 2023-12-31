package homework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 06/09/2023 Java Reflection API
 *
 * @author Wladimir Weizen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Varchar {
  String value = "VARCHAR";

  int maxLength() default 0;
}
