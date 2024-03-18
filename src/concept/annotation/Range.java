package concept.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;
}

class User {
    @Range(min = 1, max = 100)
    private int age;
    @Range(min = 3, max = 20)
    private String username;
}

class UserValidator {
    public static void validate(User user) {
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                field.setAccessible(true);
                try {
                    if (field.getType() == int.class) {
                        int value = field.getInt(user);
                        if (value < range.min() || value > range.max()) {
                            System.out.println("Validation failed for field " + field.getName());
                        }
                    } else if (field.getType() == String.class) {
                        String value = (String) field.get(user);
                        if (value.length() < range.min() || value.length() > range.max()) {
                            System.out.println("Validation failed for field " + field.getName());
                        }
                    }
                } catch (Exception ex) {

                }
            }
        }
    }
}
