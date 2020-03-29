package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ADD_ID")
    private int addId;
    @Column(name="ADD_STREET")
    private String street;
    @Column(name="ADD_BUILDING_NO")
    private String buildingNo;
    @Column(name="ADD_APARTAMENT_NO")
    private String apartamentNo;
    @Column(name="ADD_CITY")
    private String city;
    @Column(name="ADD_POSTAL_CODE")
    private String postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADD_CO_ID", referencedColumnName = "CO_ID")
    private Country country;



}
