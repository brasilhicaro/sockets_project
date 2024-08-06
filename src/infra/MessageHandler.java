package infra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import service.MessageService;

public class MessageHandler implements Runnable {
    private Socket clientSocket;
    private MessageService messageService;

    public MessageHandler(Socket clientSocket, MessageService messageService) {
        this.clientSocket = clientSocket;
        this.messageService = messageService;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                try {
                    int messageNumber = Integer.parseInt(request);
                    String response = messageService.getMessage(messageNumber);
                    out.println(response);
                } catch (NumberFormatException e) {
                    out.println("Formato de número inválido.");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar a conexão com o cliente: " + e.getMessage());
            }
        }
    }
}