package by.mikhed.ITS.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nameUser;

    @Column(nullable = false)
    private String surnameUser;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "country_id", nullable = false)
    private String countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable = false,
            updatable = false)
    private Country country;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.ROLE_USER;

    @OneToMany(mappedBy = "userSender")
    private Set<Transaction> transactionsSender;

    @OneToMany(mappedBy = "userRecipient")
    private Set<Transaction> transactionsRecipient;
}
