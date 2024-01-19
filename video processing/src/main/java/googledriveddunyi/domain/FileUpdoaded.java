package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.util.*;
import lombok.*;

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
}
