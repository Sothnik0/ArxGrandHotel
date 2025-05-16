package io.github.Sothnik0.arxgrandhotel.controller;

import io.github.Sothnik0.arxgrandhotel.model.LoginDTO;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.AuthDTO;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.RegisterDTO;
import io.github.Sothnik0.arxgrandhotel.services.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private Utilities utilities;

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody AuthDTO data){
        return utilities.login(data);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO data){
        String result = utilities.register(data);

        if (result.equals("Cliente cadastrado com sucesso!")){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
