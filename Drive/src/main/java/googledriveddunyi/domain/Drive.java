package googledriveddunyi.domain;

import googledriveddunyi.DriveApplication;
import googledriveddunyi.domain.FileUpdoaded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Drive_table")
@Data
//<<< DDD / Aggregate Root
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    private String fileSize;

    private String staus;

    private String fileId;

    private Date uploadDt;

    private String fileType;

    @PostPersist
    public void onPostPersist() {
        FileUpdoaded fileUpdoaded = new FileUpdoaded(this);
        fileUpdoaded.publishAfterCommit();
    }

    public static DriveRepository repository() {
        DriveRepository driveRepository = DriveApplication.applicationContext.getBean(
            DriveRepository.class
        );
        return driveRepository;
    }
}
//>>> DDD / Aggregate Root
