package projetomps.com.notech.util.logger;

import android.app.Notification;
import android.support.annotation.NonNull;

public abstract class AbstractLogger {

    public void log(final String tag, final String message) {
        beforeOperation();
        logMessage(tag, message);
        afterOperation();
    }

    abstract void beforeOperation();

    abstract void logMessage(@NonNull String tag, @NonNull String message);

    abstract void afterOperation();
}
