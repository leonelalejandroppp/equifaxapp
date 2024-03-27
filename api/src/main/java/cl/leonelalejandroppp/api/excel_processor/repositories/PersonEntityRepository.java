package cl.leonelalejandroppp.api.excel_processor.repositories;

import cl.leonelalejandroppp.api.excel_processor.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, UUID> {
}
