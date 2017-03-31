

package org.apache.commons.lang3.concurrent.annotation;


@java.lang.annotation.Documented
@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.FIELD , java.lang.annotation.ElementType.METHOD })
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
public @interface GuardedBy {
    java.lang.String value();
}

