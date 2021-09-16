package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pho_id")
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pho_type",nullable = false)
    private PhoneType phoneType;

    @Column(name = "pho_number",nullable = false)
    private String number;
}
