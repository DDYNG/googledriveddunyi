package googledriveddunyi.domain;

import googledriveddunyi.IndexerApplication;
import googledriveddunyi.domain.FileIndexed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Indexer_table")
@Data
//<<< DDD / Aggregate Root
public class Indexer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private String status;

    private String indexName;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();
    }

    public static IndexerRepository repository() {
        IndexerRepository indexerRepository = IndexerApplication.applicationContext.getBean(
            IndexerRepository.class
        );
        return indexerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void indexFile(FileUpdoaded fileUpdoaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Indexer indexer = new Indexer();
        repository().save(indexer);

        FileIndexed fileIndexed = new FileIndexed(indexer);
        fileIndexed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUpdoaded.get???()).ifPresent(indexer->{
            
            indexer // do something
            repository().save(indexer);

            FileIndexed fileIndexed = new FileIndexed(indexer);
            fileIndexed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
