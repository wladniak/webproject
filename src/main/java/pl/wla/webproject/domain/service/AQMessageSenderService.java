package pl.wla.webproject.domain.service;

import pl.wla.webproject.domain.MessageAQ;

public interface AQMessageSenderService {
    void sendMessage(final MessageAQ message);
}
