package br.ufu.util;

import java.util.concurrent.ExecutorService;

public final class Executors {

    private static Executors instance = null;

    private Executors() {}

    private ExecutorService threadPool =
            java.util.concurrent.Executors.newFixedThreadPool(4);

    public static Executors getInstance() {
        if (instance == null) {
            synchronized (Executors.class) {
                instance = new Executors();
            }
        }

        return instance;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
}
