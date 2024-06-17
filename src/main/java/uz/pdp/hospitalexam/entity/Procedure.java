package uz.pdp.hospitalexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "procedure")
public class Procedure extends Base {
    private String title;
    private String description;
    private Integer price;
}