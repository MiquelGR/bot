package Bot;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class BotService {

    private final OllamaChatModel model;

    public BotService() {
        this.model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")  // O `http://ollama:11434` si usas Docker
                .modelName("templanza")             // Nombre del modelo cargado con Modelfile
                .build();
    }

    public String getResponse(String prompt) {
        return model.generate(prompt);
    }
}

