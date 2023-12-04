package pl.wla.webproject.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mytestqueue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}