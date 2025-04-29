package io.github.Sothnik0.arxgrandhotel.controller;

import io.github.Sothnik0.arxgrandhotel.model.Client;
import io.github.Sothnik0.arxgrandhotel.model.ClientDTO;
import io.github.Sothnik0.arxgrandhotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("cadastrados")
    public ResponseEntity<List<ClientDTO>> getAll(){
        List<ClientDTO> allClients = clientRepository.findAll().stream().map(ClientDTO::new).toList();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping("cadastrando")
    public ResponseEntity<ClientDTO> postUser(@RequestBody ClientDTO dto){
        Client client = new Client(dto.id(), dto.name(), dto.gender(), dto.arrival(), dto.nightAmount(), dto.clientAmount(), dto.message());
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(new ClientDTO(savedClient));
    }
}
