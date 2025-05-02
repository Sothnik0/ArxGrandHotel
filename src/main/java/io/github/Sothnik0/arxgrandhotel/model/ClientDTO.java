package io.github.Sothnik0.arxgrandhotel.model;

import io.github.Sothnik0.arxgrandhotel.enums.Gender;
import io.github.Sothnik0.arxgrandhotel.enums.Roles;

import java.time.LocalDateTime;

public record ClientDTO (String id, String name, String login, String password, Gender gender, Roles role, LocalDateTime arrival, int nightAmount, int clientAmount, String message){
    public ClientDTO(Client client){
        this(client.getId(), client.getName(), client.getLogin(), client.getPassword(), client.getGender(), client.getRole(), client.getArrival(), client.getNightAmount(), client.getClientAmount(), client.getMessage());
    }
}
