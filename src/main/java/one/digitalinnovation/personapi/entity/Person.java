package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private  Long id;

    @NotBlank
    @Column(name = "per_fisrt_name",nullable = false)
    private String fisrtName;

    @Column(name = "per_cpf",unique = true,nullable = false)
    private String cpf;

    @Column(name = "per_last_name",nullable = false)
    private String lastName;

    @Column(name = "per_birth_date")
    private LocalDate birthDate;


    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(name = "person_phones", joinColumns = {
            @JoinColumn(name = "per_id")}, inverseJoinColumns = {
            @JoinColumn(name = "pho_id")})
    private List<Phone> phones;
}
