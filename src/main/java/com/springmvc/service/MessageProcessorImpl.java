package com.springmvc.service;

public class MessageProcessorImpl implements MessageProcessor {

    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMsg(String message) {
        System.out.print(message);
        messageService.sendMsg(message);
    }

}