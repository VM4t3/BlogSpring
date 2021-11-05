package application.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private BlogUser bloguser;

    private String title;

    private String content;

    @CreationTimestamp
    private LocalDateTime timestamp;

    public Blog() {
    }

    public Blog(BlogUser bloguser, String title, String content) {
        this.bloguser = bloguser;
        this.title = title;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBloguser(BlogUser bloguser) {
        this.bloguser = bloguser;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public BlogUser getBloguser() {
        return bloguser;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
