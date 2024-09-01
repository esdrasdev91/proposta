package repository;

import entity.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class ProposalRepository implements PanacheRepository<ProposalEntity> {

    public Optional<ProposalEntity> findById(String id) {
        return findById(id);
    }

    public Optional<ProposalEntity> findByCustomer(String costumer) {
        return Optional.of(find("costumer", costumer).firstResult());
    }
}
