package infra;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import service.MessageService;

public class Server {

    private int port;
    private MessageService messageService;
    private ExecutorService threadPool;

    public Server(int port, String messageFilePath) throws IOException {
        this.port = port;
        this.messageService = new MessageService(messageFilePath);
        this.threadPool = Executors.newFixedThreadPool(10);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + clientSocket.getInetAddress().getHostAddress());
                threadPool.execute(new MessageHandler(clientSocket, messageService));
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        } finally {
            threadPool.shutdown();
            System.out.println("Servidor encerrado.");
        }
    }

    public static void main(String[] args) {
        int port = 9090;
        String messageFilePath = "src/frases.txt";
        try {
            Server server = new Server(port, messageFilePath);
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
