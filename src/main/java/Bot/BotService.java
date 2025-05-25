package Bot;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    private final OllamaChatModel model;

    public BotService() {
        this.model = OllamaChatModel.builder()
                .baseUrl("http://ollama:11434")
                .modelName("templanza") // ← el que se construyó desde el Modelfile
                .build();
    }

    public String getResponse(String prompt) {
        return model.chat(prompt);
    }
}

