package io.github.Sothnik0.arxgrandhotel.services;

import io.github.Sothnik0.arxgrandhotel.model.*;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.AuthDTO;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.RegisterDTO;
import io.github.Sothnik0.arxgrandhotel.repository.ClientRepository;
import io.github.Sothnik0.arxgrandhotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TokenServices tokenServices;

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

    public ResponseEntity<ClientDTO> getClient(String id){
        Client choice = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok(new ClientDTO(choice));
    }

    public ResponseEntity<ClientUpdateDTO> updateClient(String id, Client data){
        Client user = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("O usuário não foi encontrado"));
        user.setName(data.getName());
        user.setLogin(data.getLogin());
        if (data.getPassword() != null && !data.getPassword().isBlank()){
            user.setPassword(passwordEncoder.encode(data.getPassword()));
        }

        Client updated = clientRepository.save(user);
        return ResponseEntity.ok(new ClientUpdateDTO(updated));
    }

    public void delete(String id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        clientRepository.delete(client);
    }

    public ResponseEntity<ClientDTO> saveClient(ClientDTO dto){
        Client client = new Client(dto.id(), dto.name(), dto.login(), dto.password(), dto.email(), dto.gender(), dto.role(), dto.arrival(), dto.nightAmount(), dto.clientAmount(), dto.message());
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(new ClientDTO(savedClient));
    }

    public ResponseEntity<ClientDTO> getByEmail(String email){
        Client client = clientRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok(new ClientDTO(client));
    }

    //Rooms lol
    public ResponseEntity<List<RoomDTO>> getAllRooms(){
        List<RoomDTO> all = roomRepository.findAll().stream().map(RoomDTO::new).toList();
        return ResponseEntity.ok(all);
    }

    public ResponseEntity<RoomDTO> getRoom(String id){
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));
        return ResponseEntity.ok(new RoomDTO(room));
    }

    public ResponseEntity<RoomUpdateDTO> updateRoom(String id, Room data){
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Quarto não encontrado!"));
        room.setTitle(data.getTitle());
        room.setDescr(data.getDescr());
        room.setPrice(data.getPrice());
        room.setImg(data.getImg());

        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.ok(new RoomUpdateDTO(savedRoom));
    }

    public void deleteRoom(String id){
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado..."));
        roomRepository.delete(room);
    }

    public ResponseEntity<RoomDTO> saveRoom(RoomDTO dto){
        Room room = new Room(dto.id(), dto.title(), dto.price(), dto.img(), dto.descr());
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.ok(new RoomDTO(savedRoom));
    }

    //login
    public ResponseEntity<LoginDTO> login(AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenServices.generateToken((Client) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    //Register
    public String register(RegisterDTO dto){
        if (clientRepository.findByLogin(dto.login()).isPresent()){
            return "Usuário já está cadastrado";
        }

        //Ajeitar isso depois
        Client client = new Client(dto.login(), passwordEncoder.encode(dto.password()), dto.name(), dto.email(), dto.gender(), dto.role(), dto.message());
        clientRepository.save(client);
        return "Cliente cadastrado com sucesso!";
    }
}
