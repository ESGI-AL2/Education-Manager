package fr.esgi.educationmanager.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Operation {

    public String operation;
    public Object body;

    public Operation(String operation, Object body) {
        this.operation = operation;
        this.body = body;
    }
}
