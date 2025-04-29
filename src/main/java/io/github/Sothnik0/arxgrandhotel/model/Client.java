package io.github.Sothnik0.arxgrandhotel.model;

import io.github.Sothnik0.arxgrandhotel.enums.Gender;
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
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDateTime arrival;
    private int nightAmount;
    private int clientAmount;
    private String message;
}
