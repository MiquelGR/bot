package Bot;

import org.springframework.stereotype.Service;
import dev.langchain4j.model.ollama.OllamaChatModel;

@Service
public class BotService {

    private final OllamaChatModel ollamaChatModel;

    public BotService() {
        this.ollamaChatModel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("temperanza-bot")
                .build();
    }

    public boolean isBotHealthy(Long botId) {
        try {
            // Enviar un mensaje simple como "ping" al bot
            String response = ollamaChatModel.chat("ping");

            // Si el bot responde, asumimos que está operativo
            return response != null && !response.isEmpty();
        } catch (Exception e) {
            // Si ocurre una excepción, el bot no está disponible
            return false;
        }
    }
}