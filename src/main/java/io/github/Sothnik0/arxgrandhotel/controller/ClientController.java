package io.github.Sothnik0.arxgrandhotel.controller;
import io.github.Sothnik0.arxgrandhotel.model.ClientDTO;
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

    @PostMapping("cadastrando")
    public ResponseEntity<ClientDTO> postUser(@RequestBody ClientDTO dto){
        return utilities.saveClient(dto);
    }
}
