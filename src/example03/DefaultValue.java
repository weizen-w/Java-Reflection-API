package example03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface DefaultValue {

    String value() default "";
}
