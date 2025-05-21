package resenkov.work.task1t1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;
    private BigDecimal balance;
}


