package concurrencyinpractice.chaptersix;

import java.lang.String;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutorWebServer {
    private static final int NTHREADS = 100;
    private static final Executor executor = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connect = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connect);
                }
            };
            //Use Executor to replace Thread
            executor.execute(task);
        }
    }

    private static void handleRequest(Socket connect) {
    }
}
