package fr.esgi.educationmanager.repository;

import fr.esgi.educationmanager.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
}
