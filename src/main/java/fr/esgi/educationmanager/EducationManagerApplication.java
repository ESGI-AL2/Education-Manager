package fr.esgi.educationmanager;

import fr.esgi.educationmanager.model.Job;
import fr.esgi.educationmanager.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EducationManagerApplication {

    @Autowired
    private JobRepository jr;

    public static void main(String[] args) {
        SpringApplication.run(EducationManagerApplication.class, args);


    }

    @PostConstruct
    public void init() {

        Job job1 = new Job ("builder");
        Job job2 = new Job ("electrician");
        jr.save(job1);
        jr.save(job2);
    }

}
