package io.github.Sothnik0.arxgrandhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private double price;
    private String img;
    private String descr;
}