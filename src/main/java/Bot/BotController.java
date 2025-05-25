package Bot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bot")
@RequiredArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String prompt) {
        String response = botService.getResponse(prompt);
        return ResponseEntity.ok(response);
    }
}

