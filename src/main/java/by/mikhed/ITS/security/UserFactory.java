package by.mikhed.ITS.security;

import by.mikhed.ITS.domain.Role;
import by.mikhed.ITS.domain.User;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public final class UserFactory {

    public static UserDetails create(User user) {
        return new UserPrincipal(
                user.getId(),
                user.getNameUser(),
                user.getSurnameUser(),
                user.getEmail(),
                user.getPassword(),
                user.getCountryId(),
                user.getRole(),
                mapToGrantedAuthorities(user.getRole())
        ) {
        };
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role userRole) {
        List<GrantedAuthority> userRoles = new ArrayList<>();
        userRoles.add(new SimpleGrantedAuthority(userRole.name()));
        return userRoles;
    }
}
