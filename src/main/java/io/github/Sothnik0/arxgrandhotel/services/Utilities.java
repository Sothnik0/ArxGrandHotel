package io.github.Sothnik0.arxgrandhotel.services;

import io.github.Sothnik0.arxgrandhotel.enums.Roles;
import io.github.Sothnik0.arxgrandhotel.model.Client;
import io.github.Sothnik0.arxgrandhotel.model.ClientDTO;
import io.github.Sothnik0.arxgrandhotel.model.Room;
import io.github.Sothnik0.arxgrandhotel.model.RoomDTO;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.AuthDTO;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.RegisterDTO;
import io.github.Sothnik0.arxgrandhotel.repository.ClientRepository;
import io.github.Sothnik0.arxgrandhotel.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Utilities {

    private  final ClientRepository clientRepository;

    private final RoomRepository roomRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public Utilities(ClientRepository clientRepository, RoomRepository roomRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
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

    //login
    public ResponseEntity<ClientDTO> login(AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        Client client = clientRepository.findByLogin(data.login()).orElseThrow(() -> new RuntimeException("Usuário não foi encontrado..."));
        return ResponseEntity.ok(new ClientDTO(client));
    }

    //Register
    public String register(RegisterDTO dto){
        if (clientRepository.findByLogin(dto.login()).isPresent()){
            return "Usuário já está cadastrado";
        }

        //Ajeitar isso depois
        Client client = new Client(dto.login(), passwordEncoder.encode(dto.password()), dto.name(), dto.gender(), dto.role(), dto.message());
        clientRepository.save(client);
        return "Cliente cadastrado com sucesso!";
    }
}
