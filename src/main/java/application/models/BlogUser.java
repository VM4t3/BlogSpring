package application.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.Collection;
import java.util.List;

@Entity
public class BlogUser implements UserDetails {


    private String username;

    @OneToMany(mappedBy = "bloguser",fetch = FetchType.LAZY)
    private List<Blog> blogs;

    @Id
    private String emailaddress;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole authority;

    public BlogUser(String username, String password, UserRole authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public BlogUser(String username, String password, UserRole authority,String emailaddress) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.emailaddress = emailaddress;
    }
    public BlogUser() {

    }
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getAuthority() {
        return authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthority(UserRole authority) {
        this.authority = authority;
    }
}
