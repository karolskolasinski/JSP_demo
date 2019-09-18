package JSP_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // to jest encja bazodanowa
public class Student implements IBaseEntity {
    @Id
    // dodatkowa tabela "hibernate_sequence" - sztuczne identyfikatory
    // identity - generuj identyfikator z bazy, pobierz go i przypisz do pola
    // sequence - pobierz identyfikator, przypisz go do pola, zapisz obiekt
    // table    -
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String surname;

    private int age; // "not null"
    private boolean alive; // "not null"

//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
//    private Set<Grade> gradeList;

    // wewnątrz modelu może istnieć tylko jedna relacja fetch type eager z listą
}
