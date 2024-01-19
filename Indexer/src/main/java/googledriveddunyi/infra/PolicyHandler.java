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
    IndexerRepository indexerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUpdoaded'"
    )
    public void wheneverFileUpdoaded_IndexFile(
        @Payload FileUpdoaded fileUpdoaded
    ) {
        FileUpdoaded event = fileUpdoaded;
        System.out.println(
            "\n\n##### listener IndexFile : " + fileUpdoaded + "\n\n"
        );

        // Sample Logic //
        Indexer.indexFile(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
