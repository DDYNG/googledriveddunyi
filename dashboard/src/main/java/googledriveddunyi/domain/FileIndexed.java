package googledriveddunyi.domain;

import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private String Status;
    private String indexName;
    private String userId;
}
