package com.github.avivijay19.chat.service;

import com.github.avivijay19.chat.Repository.ChatRepository;
import com.github.avivijay19.chat.model.ChatMessage;
import com.github.avivijay19.chat.model.ChatMessageHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : avinashvijayvargiya
 * @created : 27/10/24, Sunday
**/

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;


    public void storeMessageInDB(ChatMessage chatMessage) {
        ChatMessage chatMessage1 = new ChatMessage();
        chatMessage1.setContent(
            Base64.getEncoder().encodeToString(chatMessage.getContent().getBytes()));
        chatMessage1.setSender(chatMessage.getSender());
        chatRepository.save(chatMessage1);
    }

    public List<ChatMessageHistoryResponse> getHistory() {
        List<ChatMessage> chatMessageList = chatRepository.findAll();
        return chatMessageList
            .stream()
            .map(chatMessage -> new ChatMessageHistoryResponse(chatMessage.getContent(),
                chatMessage.getSender()))
            .collect(Collectors.toList());
    }
}
