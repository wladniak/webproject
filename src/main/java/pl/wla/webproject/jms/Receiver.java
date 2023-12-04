package pl.wla.webproject.jms;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    /*temporary disabled
    @JmsListener(destination = "mytestqueue")

     */
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}