package com.github.avivijay19.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author : avinashvijayvargiya
 * @created : 27/10/24, Sunday
 **/

public class ChatMessageHistoryResponse {

    private String base64EncodedMessage;
    private String senderName;

    public ChatMessageHistoryResponse(String base64EncodedMessage, String senderName) {
        this.base64EncodedMessage = base64EncodedMessage;
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getBase64EncodedMessage() {
        return base64EncodedMessage;
    }

    public void setBase64EncodedMessage(String base64EncodedMessage) {
        this.base64EncodedMessage = base64EncodedMessage;
    }
}
