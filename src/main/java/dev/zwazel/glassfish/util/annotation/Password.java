package dev.zwazel.glassfish.util.annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Password annotation.
 *
 * @author Zwazel
 * @since 1.3.0
 */
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {
    /**
     * The message to display.
     *
     * @return The message to display.
     * @author Zwazel
     * @since 1.3.0
     */
    String message() default "Invalid Password";

    /**
     * The groups the constraint belongs to.
     *
     * @return The groups the constraint belongs to.
     * @author Zwazel
     * @since 1.3.0
     */
    Class<?>[] groups() default {};

    /**
     * The payload of the constraint.
     *
     * @return The payload of the constraint.
     * @author Zwazel
     * @since 1.3.0
     */
    Class<?>[] payload() default {};
}
