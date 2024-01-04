package ricardo.vinicius.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ricardo.vinicius.report.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {}
