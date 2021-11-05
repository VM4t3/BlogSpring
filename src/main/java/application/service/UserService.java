package application.service;


import application.models.Blog;
import application.models.BlogUser;
import application.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @PersistenceContext
    private EntityManager entityMngr;

    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

  //@Transactional
    @Transactional()
    public boolean registerUsers(BlogUser user) {
        try {
            String userPw = encoder.encode(user.getPassword());
            user.setPassword(userPw);

            //BlogUser user = new BlogUser("user", userPw, UserRole.USER,"user@gmail.com");
           // BlogUser admin = new BlogUser("admin", adminPw, UserRole.ADMIN,"admin@gmail.com");

            entityMngr.persist(user);
           // entityMngr.persist(admin);

            return true;
        } catch ( UnexpectedRollbackException e) {
            System.out.println(e);
            return false;
        }
    }

    @Transactional
    public List<BlogUser> getAllUsers() {
        return entityMngr.createQuery("SELECT user FROM BlogUser user", BlogUser.class)
                .getResultList();
    }





    @Override
    @Transactional
    public BlogUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return entityMngr.createQuery("SELECT user FROM BlogUser user WHERE user.username = :name", BlogUser.class)
                .setParameter("name", username)
                .getSingleResult();
    }

    @Transactional
    public List<Blog> getAllBlogs() {
        return entityMngr.createQuery("SELECT blog FROM Blog blog", Blog.class)
                .getResultList();
    }
}
