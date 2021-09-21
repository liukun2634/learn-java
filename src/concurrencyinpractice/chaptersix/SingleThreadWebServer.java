package concurrencyinpractice.chaptersix;

import java.lang.String;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connect = socket.accept();
            handleRequest(connect);
        }
    }

    private static void handleRequest(Socket connect) {
    }
}
