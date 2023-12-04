package pl.wla.webproject.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import pl.wla.webproject.domain.MessageAQ;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AQMessageSenderServiceImpl implements AQMessageSenderService {
    private static final String QUEUE_NAME = "mytestqueue";
    private final JmsMessagingTemplate jmsTemplate;

    @Override
    public void sendMessage(MessageAQ message) {
        jmsTemplate.convertAndSend(QUEUE_NAME, message.getText());
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wla");
        map.put("description", "wla desc");
        //   jmsTemplate.convertAndSend(QUEUE_NAME, map);
        System.out.println("send");
    }
}
