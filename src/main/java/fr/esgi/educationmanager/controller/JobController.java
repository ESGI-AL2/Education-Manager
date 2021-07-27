package fr.esgi.educationmanager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.educationmanager.json.Operation;
import fr.esgi.educationmanager.model.Job;
import fr.esgi.educationmanager.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    private JobService js;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/job")
    public Job createJob (@RequestBody Job job) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Job j = js.saveJob(job);
        String s = mapper.writeValueAsString(new Operation("job_create", j));
        sendMessage("job1", s);
        return j;
    }

    private void sendMessage(String topicName, String message) {

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
