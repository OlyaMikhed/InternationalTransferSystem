package by.mikhed.ITS.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@Entity
public class Country {

    @Id
    private String id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "country")
    private Set<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
