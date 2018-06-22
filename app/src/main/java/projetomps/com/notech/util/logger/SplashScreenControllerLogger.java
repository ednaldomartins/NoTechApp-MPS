package projetomps.com.notech.util.logger;

import android.support.annotation.NonNull;
import android.util.Log;

public class SplashScreenControllerLogger extends AbstractLogger {
    private final String tag;
    private final String operation;

    public SplashScreenControllerLogger(String tag, String operation) {
        this.tag = tag;
        this.operation = operation;
    }

    @Override
    public void beforeOperation() {
        Log.i(tag, operation);
    }

    @Override
    public void logMessage(@NonNull String tag, @NonNull String message) {
        Log.i(tag, message);
    }

    @Override
    public void afterOperation() {
        Log.i(tag, operation);
    }
}
