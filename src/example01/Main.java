package example01;

import java.lang.reflect.*;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {

    public static <T> void printInfo(Class<T> aClass) {
        System.out.println(aClass.getTypeName() +
                " " + aClass.getSimpleName() +
                " " + aClass.getPackageName());

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
        }

        Method[] methods = aClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.print(method.getReturnType() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType() + " " + parameter.getName() + " ");
            }
            System.out.println(")");
        }

        Constructor<?>[] constructors = aClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }

    }

    public static void main(String[] args) {
//        UsersService service = context.getBean(UsersService.class);

        printInfo(PasswordValidator.class);
        System.out.println("------");
        printInfo(Integer.class);


    }
}
