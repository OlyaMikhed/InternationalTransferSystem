package by.mikhed.ITS.security;

import by.mikhed.ITS.domain.Role;
import by.mikhed.ITS.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {

    private final User user;
    Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(
            Integer id,
            String nameUser,
            String surnameUser,
            String email,
            String password,
            String countryId,
            Role role,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.user = User.builder()
                .id(id)
                .nameUser(nameUser)
                .surnameUser(surnameUser)
                .email(email)
                .password(password)
                .countryId(countryId)
                .role(role)
                .build();
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getId() {
        return user.getId();
    }
}
