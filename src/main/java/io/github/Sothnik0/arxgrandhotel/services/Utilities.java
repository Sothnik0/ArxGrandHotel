package io.github.Sothnik0.arxgrandhotel.services;

import io.github.Sothnik0.arxgrandhotel.model.Client;
import io.github.Sothnik0.arxgrandhotel.model.ClientDTO;
import io.github.Sothnik0.arxgrandhotel.model.Room;
import io.github.Sothnik0.arxgrandhotel.model.RoomDTO;
import io.github.Sothnik0.arxgrandhotel.repository.ClientRepository;
import io.github.Sothnik0.arxgrandhotel.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Utilities {

    private  final ClientRepository clientRepository;

    private final RoomRepository roomRepository;

    public Utilities(ClientRepository clientRepository, RoomRepository roomRepository) {
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
    }

    //Clients lol
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        List<ClientDTO> all = clientRepository.findAll().stream().map(ClientDTO::new).toList();
        return ResponseEntity.ok(all);
    }

    public ResponseEntity<ClientDTO> saveClient(ClientDTO dto){
        Client client = new Client(dto.id(), dto.name(), dto.login(), dto.password(), dto.gender(), dto.role(), dto.arrival(), dto.nightAmount(), dto.clientAmount(), dto.message());
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(new ClientDTO(savedClient));
    }

    //Rooms lol
    public ResponseEntity<List<RoomDTO>> getAllRooms(){
        List<RoomDTO> all = roomRepository.findAll().stream().map(RoomDTO::new).toList();
        return ResponseEntity.ok(all);
    }

    public ResponseEntity<RoomDTO> saveRoom(RoomDTO dto){
        Room room = new Room(dto.id(), dto.title(), dto.price(), dto.img(), dto.descr());
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.ok(new RoomDTO(savedRoom));
    }
}
