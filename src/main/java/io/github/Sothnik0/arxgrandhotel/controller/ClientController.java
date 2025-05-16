package io.github.Sothnik0.arxgrandhotel.controller;
import io.github.Sothnik0.arxgrandhotel.model.Client;
import io.github.Sothnik0.arxgrandhotel.model.ClientDTO;
import io.github.Sothnik0.arxgrandhotel.model.ClientUpdateDTO;
import io.github.Sothnik0.arxgrandhotel.services.Utilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class ClientController {

    private final Utilities utilities;

    public ClientController(Utilities utilities) {
        this.utilities = utilities;
    }

    @GetMapping("cadastrados")
    public ResponseEntity<List<ClientDTO>> getAll(){
        return utilities.getAllClients();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientDTO> getUser(@PathVariable String id){
        return utilities.getClient(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientDTO> getByEmail(@PathVariable String email) {return utilities.getByEmail(email);}

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<ClientUpdateDTO> patchUser(@PathVariable String id, @RequestBody Client data){
        return utilities.updateClient(id, data);
    }

    @DeleteMapping("deletar/{id}")
    public void deleteUser(@PathVariable String id){
        utilities.delete(id);
    }

    @PostMapping("cadastrando")
    public ResponseEntity<ClientDTO> postUser(@RequestBody ClientDTO dto){
        return utilities.saveClient(dto);
    }
}
