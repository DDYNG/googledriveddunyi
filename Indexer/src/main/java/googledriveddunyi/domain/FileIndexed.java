package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private String status;
    private String indexName;
    private String userId;

    public FileIndexed(Indexer aggregate) {
        super(aggregate);
    }

    public FileIndexed() {
        super();
    }
}
//>>> DDD / Domain Event
