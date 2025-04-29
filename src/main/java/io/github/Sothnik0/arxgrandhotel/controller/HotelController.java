package io.github.Sothnik0.arxgrandhotel.controller;

import io.github.Sothnik0.arxgrandhotel.model.Room;
import io.github.Sothnik0.arxgrandhotel.model.RoomDTO;
import io.github.Sothnik0.arxgrandhotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("all")
    public ResponseEntity<List<RoomDTO>> getAll(){
        List<RoomDTO> all = roomRepository.findAll().stream().map(RoomDTO::new).toList();
        return ResponseEntity.ok(all);
    }
    @PostMapping("new")
    public ResponseEntity<RoomDTO> saveHotel(@RequestBody RoomDTO dto){
        Room room = new Room(dto.id(), dto.title(), dto.price(), dto.img(), dto.descr());
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.ok(new RoomDTO(savedRoom));
    }
}
