package Bot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/bot")
public class BotController {

    private final BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @GetMapping("/health/{botId}")
    public ResponseEntity<String> checkBotHealth(@PathVariable("botId") Long botId) {
        boolean isHealthy = botService.isBotHealthy(botId);

        if (isHealthy) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(503).body("Bot service is unavailable");
        }
    }
}