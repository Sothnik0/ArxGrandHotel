package io.github.Sothnik0.arxgrandhotel.model;

public record RoomDTO(String id, String title, double price, String img, String descr) {
    public RoomDTO(Room room){
        this(room.getId(), room.getTitle(), room.getPrice(), room.getImg(), room.getDescr());
    }
}
