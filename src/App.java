import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9090;

        try {
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Conectado ao servidor. Digite o número da mensagem desejada (0 para aleatória) ou 'sair' para finalizar:");

            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("sair")) {
                out.println(input);
                System.out.println("Resposta do servidor: " + in.readLine());
            }

            socket.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o servidor: " + e.getMessage());
        }
    }
}
