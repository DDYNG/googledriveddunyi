package googledriveddunyi.domain;

import googledriveddunyi.VideoProcessingApplication;
import googledriveddunyi.domain.FileStreamingProcessed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Videoprocessing_table")
@Data
//<<< DDD / Aggregate Root
public class Videoprocessing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private String status;

    private String videUrl;

    @PostPersist
    public void onPostPersist() {
        FileStreamingProcessed fileStreamingProcessed = new FileStreamingProcessed(
            this
        );
        fileStreamingProcessed.publishAfterCommit();
    }

    public static VideoprocessingRepository repository() {
        VideoprocessingRepository videoprocessingRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoprocessingRepository.class
        );
        return videoprocessingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void filecheckIsVideo(FileUpdoaded fileUpdoaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Videoprocessing videoprocessing = new Videoprocessing();
        repository().save(videoprocessing);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileUpdoaded.get???()).ifPresent(videoprocessing->{
            
            videoprocessing // do something
            repository().save(videoprocessing);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
