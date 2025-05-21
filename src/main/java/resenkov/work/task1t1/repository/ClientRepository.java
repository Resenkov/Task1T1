package resenkov.work.task1t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import resenkov.work.task1t1.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}