package su.psergeev77.service.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.psergeev77.service.client.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUserName(String userName);
}
