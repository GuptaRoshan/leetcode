package concept.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Sound {
    String value() default "";
}

class Cat {
    @Sound(value = "")
    public void speak() {
        System.out.println("Cat Speaks");
    }

    public void walks() {
        System.out.println("Cat Walks");
    }
}

class AnnotationProcessor {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Method[] methods = cat.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Sound.class)) {
                Sound annotation = method.getAnnotation(Sound.class);
                String description = annotation.value();
                System.out.println("Executing method: " + method.getName());
                System.out.println("Description: " + description);
            }
        }
    }
}
