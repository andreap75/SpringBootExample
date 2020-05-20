package com.example.demo;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @JmsListener(destination = "CdQueue")
    public void receiveMessage(final String message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        LOG.info("Application : response received : {}", message);  
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}