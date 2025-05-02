package io.github.Sothnik0.arxgrandhotel.repository;

import io.github.Sothnik0.arxgrandhotel.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByLogin(String username);
}
