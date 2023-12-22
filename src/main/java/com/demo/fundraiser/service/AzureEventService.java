package com.demo.fundraiser.service;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.BinaryData;
import com.azure.messaging.eventgrid.EventGridEvent;
import com.azure.messaging.eventgrid.EventGridPublisherClient;
import com.azure.messaging.eventgrid.EventGridPublisherClientBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
@Service
public class AzureEventService {

    private final EventGridPublisherClient<EventGridEvent> pubClient;

    public AzureEventService() {
        pubClient = new EventGridPublisherClientBuilder()
                        .endpoint(System.getenv("CUSTOMCONNSTR_EVENT_TOPIC_ENDPOINT"))
                        .credential(new AzureKeyCredential(System.getenv("CUSTOMCONNSTR_EVENT_TOPIC_KEY")))
                        .buildEventGridEventPublisherClient();
    }

    public void publishEvent(double amount){
        Flux.range(0, 1)
                .doOnNext(number -> {
                    String body = String.format("Incoming fund : %s", amount);
                    EventGridEvent event = new EventGridEvent("com/demo/fundraiser", "New.Funds.Added", BinaryData.fromObject(body), "0.1");
                    pubClient.sendEvent(event);
                    System.out.format("Done publishing event: %s.%n", body);
                })
                .doOnComplete(() -> System.out.println("Done publishing events using event grid."))
                .blockLast();
    }
}
