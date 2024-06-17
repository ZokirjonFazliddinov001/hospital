package uz.pdp.hospitalexam.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    @ManyToOne
    private Role role;


    public String getFullName(){
        return firstName + " " + lastName;
    }
}