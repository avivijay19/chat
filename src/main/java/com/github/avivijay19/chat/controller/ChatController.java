package com.github.avivijay19.chat.controller;

import com.github.avivijay19.chat.model.ChatMessage;
import com.github.avivijay19.chat.model.ChatMessageHistoryResponse;
import com.github.avivijay19.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import java.util.List;
import java.util.Objects;

/**
 * @author : avinashvijayvargiya
 * @created : 27/10/24, Sunday
**/

@Controller
@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(headerAccessor.getSessionAttributes())
            .put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatService.storeMessageInDB(chatMessage);
        return chatMessage;
    }

    @GetMapping("/getHistory")
    public List<ChatMessageHistoryResponse> getHistory() {
        return chatService.getHistory();
    }

    @GetMapping("/convertTheMessage")
    public String convertTheMessage(@RequestParam String chatMessage) {
        return Base64Coder.decodeString(chatMessage);
    }
}
