package com.mohamed.whatsappclone.chat;

import org.springframework.stereotype.Service;

@Service
public class ChatMapper {

    private final ChatRepository chatRepository;

    public ChatMapper(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatResponse toChatResponse(Chat chat, String senderId) {
        return ChatResponse.builder()
                .id(chat.getId())
                .name(chat.getChatName(senderId))
                .unreadCount(chat.getUnreadMessageCount(senderId))
                .lastMessage(chat.getLastMessage())
                .isRecipientOnline(chat.getRecipient().isUserOnline())
                .senderId(chat.getSender().getId())
                .receiverId(chat.getRecipient().getId())
                .lastMessageTime(chat.getLastMessageTime())
                .build();
    }


  }
