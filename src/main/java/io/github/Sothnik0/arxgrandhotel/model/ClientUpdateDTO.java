package io.github.Sothnik0.arxgrandhotel.model;

public record ClientUpdateDTO(String id, String nome, String login, String password) {
    public ClientUpdateDTO(Client client) {
        this(client.getId(), client.getName(), client.getLogin(), client.getPassword());
    }
}
