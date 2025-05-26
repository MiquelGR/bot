package Message;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final OllamaChatModel model;

    public MessageService() {
        this.model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("temperanza-bot")
                .build();
    }

    public String getResponse(String prompt) {
        return model.chat(prompt);
    }
}

