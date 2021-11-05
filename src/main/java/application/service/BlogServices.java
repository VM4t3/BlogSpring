package application.service;

import application.models.Blog;
import application.models.BlogUser;
import application.models.UserRole;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServices    {

    @PersistenceContext
    private EntityManager entityMngr;

    private PasswordEncoder encoder;

    @Autowired
    public BlogServices(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional()
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = new ArrayList<>();
        blogs =  entityMngr.createQuery("SELECT blog FROM Blog blog", Blog.class)
                .getResultList();
        return blogs;
    }

    @Transactional()
    public boolean presistBlog(Blog blog) {
        try {
         //   String adminPw = encoder.encode("admin");


          //  BlogUser admin = new BlogUser("admin", adminPw, UserRole.ADMIN,"admin@gmail.com");
          //  Blog newBlog = new Blog(admin,"title2", "content2");

            entityMngr.persist(blog);

            return true;
        } catch ( Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
