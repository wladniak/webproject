package pl.wla.webproject.domain.service;

import javax.jms.JMSException;

public interface AQMessageListenerService {
    void receiveMessage() throws JMSException;
}
