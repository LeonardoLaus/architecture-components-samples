package ext.android.arch.component.lifecycles;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

import java.util.concurrent.atomic.AtomicBoolean;

import ext.android.arch.component.annotations.NonStack;
import ext.android.arch.component.stacks.ActivityStack;

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public final class LifecycleDispatcher {

    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    public static void init(@NonNull Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        Application application = (Application) context.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }

    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            final Class<? extends Activity> cls = activity.getClass();
            if (!cls.isAnnotationPresent(NonStack.class)) {
                ActivityStack.get().push(activity);
            }
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            final Class<? extends Activity> cls = activity.getClass();
            if (!cls.isAnnotationPresent(NonStack.class)) {
                ActivityStack.get().pop(activity);
            }
        }
    }
}
