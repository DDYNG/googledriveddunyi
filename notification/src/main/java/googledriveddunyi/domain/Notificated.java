package googledriveddunyi.domain;

import googledriveddunyi.domain.*;
import googledriveddunyi.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Notificated extends AbstractEvent {

    private Long id;

    public Notificated(Notification aggregate) {
        super(aggregate);
    }

    public Notificated() {
        super();
    }
}
//>>> DDD / Domain Event
