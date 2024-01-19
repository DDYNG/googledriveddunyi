package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileUpdoaded extends AbstractEvent {

    private Long id;
    private String fileName;
    private String fileSize;
    private String staus;
    private String fileId;
    private Date uploadDt;
    private String fileType;

    public FileUpdoaded(Drive aggregate) {
        super(aggregate);
    }

    public FileUpdoaded() {
        super();
    }
}
//>>> DDD / Domain Event
