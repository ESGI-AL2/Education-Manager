package fr.esgi.educationmanager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany
    private List<Trademan> trademen;

    @OneToMany
    private List<Certificate> certificates;
}
