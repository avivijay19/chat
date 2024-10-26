package com.github.avivijay19.chat.Repository;

import com.github.avivijay19.chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : avinashvijayvargiya
 * @created : 27/10/24, Sunday
 **/

@Repository
public interface ChatRepository extends MongoRepository<ChatMessage, String> {
}
