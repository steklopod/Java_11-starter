package ru.steklopod.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Table
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20)
    @ApiModelProperty(notes = "Имя пользователя")
    private String firstName;

    @ApiModelProperty(notes = "Фамилия пользователя")
    private String lastName;

    @Email
    @ApiModelProperty(notes = "Email пользователя")
    private String userEmail;

    @ApiModelProperty(notes = "Телефон пользователя")
    private String  phone;
}
