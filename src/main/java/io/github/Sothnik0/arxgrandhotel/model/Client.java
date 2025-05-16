package io.github.Sothnik0.arxgrandhotel.model;

import io.github.Sothnik0.arxgrandhotel.enums.Gender;
import io.github.Sothnik0.arxgrandhotel.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login;
    private String password;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private LocalDateTime arrival;
    private int nightAmount;
    private int clientAmount;
    private String message;

    //Contrutor para registro ai
    public Client(String login, String password, String name, String email, Gender gender, Roles role, String message) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.role = role;
        this.message = message;
    }
}
