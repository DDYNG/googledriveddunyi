package googledriveddunyi.infra;

import googledriveddunyi.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class VideoprocessingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Videoprocessing>> {

    @Override
    public EntityModel<Videoprocessing> process(
        EntityModel<Videoprocessing> model
    ) {
        return model;
    }
}
