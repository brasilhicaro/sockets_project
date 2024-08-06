package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageService {

    private List<String> messages;
    private Random random;

    public MessageService(String filePath) throws IOException {
        messages = new ArrayList<>();
        random = new Random();
        loadMessages(filePath);
    }

    private void loadMessages(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int totalMessages = Integer.parseInt(br.readLine());
            for (int i = 0; i < totalMessages; i++) {
                messages.add(br.readLine());
            }
        }
    }

    public String getMessage(int messageNumber) {
        if (messageNumber == 0) {
            return getRandomMessage();
        } else if (messageNumber > 0 && messageNumber <= messages.size()) {
            return messages.get(messageNumber - 1);
        } else {
            return "Número de mensagem inválido. Solicite um número entre 1 e " + messages.size() + ".";
        }
    }

    private String getRandomMessage() {
        int randomIndex = random.nextInt(messages.size());
        return messages.get(randomIndex);
    }
}