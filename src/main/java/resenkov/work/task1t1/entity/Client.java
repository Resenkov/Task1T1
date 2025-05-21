package resenkov.work.task1t1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;
    @NotNull
    private String middleName;
}