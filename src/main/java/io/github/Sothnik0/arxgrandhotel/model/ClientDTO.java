package io.github.Sothnik0.arxgrandhotel.model;

import io.github.Sothnik0.arxgrandhotel.enums.Gender;

import java.time.LocalDateTime;

public record ClientDTO (String id, String name, Gender gender, LocalDateTime arrival, int nightAmount, int clientAmount, String message){
    public ClientDTO(Client client){
        this(client.getId(), client.getName(), client.getGender(), client.getArrival(), client.getNightAmount(), client.getClientAmount(), client.getMessage());
    }
}
