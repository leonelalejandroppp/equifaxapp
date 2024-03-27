package cl.leonelalejandroppp.api.excel_processor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String rut;

    @CreationTimestamp
    private LocalDateTime created;

    @OneToOne(mappedBy = "personEntity", cascade = CascadeType.ALL)
    private AddressEntity address;
}
