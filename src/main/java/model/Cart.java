package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @Column(name = "CRT_QUANTITY")
    private int quantity;


}
