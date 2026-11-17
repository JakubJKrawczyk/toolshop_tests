package core.JacksonHttpAnnotationIntrospector;

public final class RequiredFields {

    public static void validate(Object body, HttpType.Direction direction) {
        for (var field : body.getClass().getDeclaredFields()) {
            HttpType type = field.getAnnotation(HttpType.class);
            if (type == null || !type.required()) continue;
            if (type.value() != HttpType.Direction.BOTH
                    && type.value() != direction) continue;
            if (field.getType().isPrimitive()) continue;

            try {
                field.setAccessible(true);
                if (field.get(body) == null) {
                    throw new IllegalArgumentException(
                            "Required field for " + direction + ": " + field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}