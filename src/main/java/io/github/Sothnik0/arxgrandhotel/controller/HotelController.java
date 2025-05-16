package io.github.Sothnik0.arxgrandhotel.controller;

import io.github.Sothnik0.arxgrandhotel.model.Room;
import io.github.Sothnik0.arxgrandhotel.model.RoomDTO;
import io.github.Sothnik0.arxgrandhotel.model.RoomUpdateDTO;
import io.github.Sothnik0.arxgrandhotel.services.Utilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    private final Utilities utilities;

    public HotelController(Utilities utilities) {
        this.utilities = utilities;
    }

    @GetMapping("all")
    public ResponseEntity<List<RoomDTO>> getAll(){
        return utilities.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoom(String id){
        return utilities.getRoom(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<RoomUpdateDTO> updateRoom(@PathVariable String id, @RequestBody Room room){
        return utilities.updateRoom(id, room);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteRoom(String id){
        utilities.deleteRoom(id);
    }

    @PostMapping("new")
    public ResponseEntity<RoomDTO> saveHotel(@RequestBody RoomDTO dto){
        return utilities.saveRoom(dto);
    }
}
