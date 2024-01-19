package googledriveddunyi.domain;

import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileStreamingProcessed extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private String videUrl;
    private String fileId;
}
