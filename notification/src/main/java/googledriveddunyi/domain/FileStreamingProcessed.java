package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileStreamingProcessed extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private String videUrl;
    private String fileId;
}
