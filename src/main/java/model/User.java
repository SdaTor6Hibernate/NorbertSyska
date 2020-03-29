package model;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USR_ID")
    private int usrId;
    @Column(name="USR_FIRSTNAME")
    private String firstName;
    @Column(name="USR_LASTNAME")
    private String lastName;
    @Column(name="USR_PASSWORD")
    private String password;
    @Column(name="USR_EMAIL")
    private String email;
    @Column(name="USR_BIRTH_DATE")
    private LocalDateTime birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;


}
