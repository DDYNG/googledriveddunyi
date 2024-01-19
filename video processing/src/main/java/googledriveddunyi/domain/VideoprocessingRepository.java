package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "videoprocessings",
    path = "videoprocessings"
)
public interface VideoprocessingRepository
    extends PagingAndSortingRepository<Videoprocessing, Long> {}
