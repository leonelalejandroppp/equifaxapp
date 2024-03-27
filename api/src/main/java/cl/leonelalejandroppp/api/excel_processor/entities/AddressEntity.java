package cl.leonelalejandroppp.api.excel_processor.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String address;

    private String country;

    @OneToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private PersonEntity personEntity;
}
