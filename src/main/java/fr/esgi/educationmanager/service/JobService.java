package fr.esgi.educationmanager.service;

import fr.esgi.educationmanager.model.Job;
import fr.esgi.educationmanager.repository.JobRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class JobService {

    @Autowired
    private JobRepository jr;

    public Job saveJob (Job job) {
        Job saveJob = jr.save(job);
        return saveJob;
    }


}
