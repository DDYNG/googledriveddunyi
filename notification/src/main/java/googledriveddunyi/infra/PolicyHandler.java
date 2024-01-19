package googledriveddunyi.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledriveddunyi.config.kafka.KafkaProcessor;
import googledriveddunyi.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileStreamingProcessed'"
    )
    public void wheneverFileStreamingProcessed_Notificate(
        @Payload FileStreamingProcessed fileStreamingProcessed
    ) {
        FileStreamingProcessed event = fileStreamingProcessed;
        System.out.println(
            "\n\n##### listener Notificate : " + fileStreamingProcessed + "\n\n"
        );

        // Sample Logic //
        Notification.notificate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUpdoaded'"
    )
    public void wheneverFileUpdoaded_Notificate(
        @Payload FileUpdoaded fileUpdoaded
    ) {
        FileUpdoaded event = fileUpdoaded;
        System.out.println(
            "\n\n##### listener Notificate : " + fileUpdoaded + "\n\n"
        );

        // Sample Logic //
        Notification.notificate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
