package googledriveddunyi.infra;

import googledriveddunyi.config.kafka.KafkaProcessor;
import googledriveddunyi.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUpdoaded_then_CREATE_1(
        @Payload FileUpdoaded fileUpdoaded
    ) {
        try {
            if (!fileUpdoaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFileId(fileUpdoaded.getFileId());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUpdoaded_then_UPDATE_1(
        @Payload FileUpdoaded fileUpdoaded
    ) {
        try {
            if (!fileUpdoaded.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByUserId(
                fileUpdoaded.getFileId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setUploadStaus(fileUpdoaded.getStaus());
                dashboard.setFileSize(fileUpdoaded.getFileSize());
                dashboard.setFileName(fileUpdoaded.getFileName());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_2(
        @Payload FileIndexed fileIndexed
    ) {
        try {
            if (!fileIndexed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByUserId(
                fileIndexed.getUserId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setIndexStatus(fileIndexed.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileStreamingProcessed_then_UPDATE_3(
        @Payload FileStreamingProcessed fileStreamingProcessed
    ) {
        try {
            if (!fileStreamingProcessed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByUserId(
                fileStreamingProcessed.getUserId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setVideoUrl(fileStreamingProcessed.getVideUrl());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
