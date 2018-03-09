package ext.android.arch.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by roothost on 2018/3/5.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
public @interface Singleton {
}
