package concurrency.chaptersix;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifecycleWebServer {
    private final ExecutorService exec = Executors.newFixedThreadPool(100);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            try {
                final Socket connection = socket.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(connection);
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown())
                    System.out.println("task submission rejected");
            }
        }
    }

    public void stop() {exec.shutdown();}

    private void handleRequest(Socket connection) {
        if (isShutdownRequest(connection)) {
            //receive shut down request
            stop();
        } else {
            //handle request
        }

    }

    private boolean isShutdownRequest(Socket connection) {
        return false;
    }
}
