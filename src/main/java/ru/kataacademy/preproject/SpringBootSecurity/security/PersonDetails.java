//package ru.kataacademy.preproject.SpringBootSecurity.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//public class PersonDetails implements UserDetails {
//
//    private final Person person;
//
//    public PersonDetails(Person person) {
//        this.person = person;
//    }
//
//    @Override
//    /** Авторзация, здесь мы будем получать список доступных прав пользователя*/
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return person.getRoles().stream().map(p -> new SimpleGrantedAuthority(p.getRole())).collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return this.person.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.person.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Person getPerson() {
//        return this.person;
//    }
//}
