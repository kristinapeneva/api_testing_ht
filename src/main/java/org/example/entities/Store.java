package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Store {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

}
