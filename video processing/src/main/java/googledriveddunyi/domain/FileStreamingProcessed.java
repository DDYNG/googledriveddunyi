package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileStreamingProcessed extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private String videUrl;
    private String fileId;

    public FileStreamingProcessed(Videoprocessing aggregate) {
        super(aggregate);
    }

    public FileStreamingProcessed() {
        super();
    }
}
//>>> DDD / Domain Event
