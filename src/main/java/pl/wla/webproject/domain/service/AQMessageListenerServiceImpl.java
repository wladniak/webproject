package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AQMessageListenerServiceImpl implements AQMessageListenerService {

    private static final String QUEUE_NAME = "mytestqueue";
    private final JmsMessagingTemplate jmsTemplate;

    @Override
    public void receiveMessage() throws JMSException {
        String str = jmsTemplate.receiveAndConvert(QUEUE_NAME, String.class);
        //String str = (String) jmsTemplate.receiveAndConvert();
        System.out.println("receive: " + str);
    }

}
