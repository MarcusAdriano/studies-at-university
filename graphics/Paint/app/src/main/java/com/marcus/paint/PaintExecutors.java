package com.marcus.paint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Marcus
 */
public class PaintExecutors {

    private static PaintExecutors instance = null;
    private ExecutorService mService;

    private PaintExecutors() {
        mService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public static PaintExecutors getInstance() {
        if (instance == null) {
            synchronized (PaintExecutors.class) {
                if (instance == null) {
                    instance = new PaintExecutors();
                }
            }
        }

        return instance;
    }

    public ExecutorService getService() {
        return mService;
    }

}
