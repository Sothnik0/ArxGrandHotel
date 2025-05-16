package io.github.Sothnik0.arxgrandhotel.model;

public record RoomUpdateDTO(String title, double price, String img, String descr) {
    public RoomUpdateDTO(Room room) {
        this(room.getTitle(), room.getPrice(), room.getImg(), room.getDescr());
    }
}
