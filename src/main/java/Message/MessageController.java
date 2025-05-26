package Message;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/message")
public class MessageController {

    private final MessageService messageService;
    private final RestTemplate restTemplate;

    public MessageController(MessageService messageService, RestTemplate restTemplate) {
        this.messageService = messageService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/{matchId}")
    public ResponseEntity<String> sendMessage(
            @PathVariable("matchId") Long matchId,
            @RequestBody MessageDTO messageDTO) {
        String prompt = messageDTO.getText();

        // Get the bot's response
        String messageResponse = messageService.getResponse(prompt);

        // Construct a new MessageDTO object for the request body
        MessageDTO responseMessage = new MessageDTO();
        responseMessage.setBotId(messageDTO.getBotId());
        responseMessage.setText(messageResponse);
        responseMessage.setTime(java.time.LocalDateTime.now());

        // URL for localhost:8080
        String targetUrl = "http://localhost:8080/api/v0/message/" + matchId;

        // Create the request with the MessageDTO body
        HttpEntity<MessageDTO> request = new HttpEntity<>(responseMessage);

        // Send the response to localhost:8080
        restTemplate.postForEntity(targetUrl, request, Void.class);

        // Return HTTP 200
        return ResponseEntity.ok().build();
    }
}