package jsp_studnet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grade implements IBaseEntity { // ocena z przedmiotu
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    private double value;

    @ToString.Exclude
    @ManyToOne()
    private Student student;

    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }
}
