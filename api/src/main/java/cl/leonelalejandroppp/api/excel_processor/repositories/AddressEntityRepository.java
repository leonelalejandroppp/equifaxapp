package cl.leonelalejandroppp.api.excel_processor.repositories;

import cl.leonelalejandroppp.api.excel_processor.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, UUID> {
}
