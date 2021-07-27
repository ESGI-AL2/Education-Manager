package fr.esgi.educationmanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Certificate {

    @Id
    @GeneratedValue
    private int id;

    private String Name;

    @ManyToOne
    private Job job;

    @ManyToMany
    private List<Trademan> trademen;
}
