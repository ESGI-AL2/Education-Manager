package fr.esgi.educationmanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Trademan {


    @Id
    @GeneratedValue
    private int id;

    private String name;


    @ManyToOne
    private Job job;

    private boolean available;

    @ManyToMany
    private List<Certificate> certificates;
}
