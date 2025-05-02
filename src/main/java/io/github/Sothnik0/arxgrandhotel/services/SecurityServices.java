package io.github.Sothnik0.arxgrandhotel.services;

import io.github.Sothnik0.arxgrandhotel.model.Client;
import io.github.Sothnik0.arxgrandhotel.model.userSecurity.ClientDetails;
import io.github.Sothnik0.arxgrandhotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServices implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = clientRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuário " + username + "não encontrado!"));
        return new ClientDetails(user);
    }
}
