package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "published",columnDefinition = "TINYINT(1)",nullable = false)
    private boolean published;
    @Lob
    @Column(name = "content",columnDefinition = "TEXT",nullable = false)
    private String content;
    @Column(name = "meta_title",columnDefinition = "VARCHAR(100)",nullable = true)
    private String metaTitle;
    @Column(name = "summary",columnDefinition = "TEXT",nullable = true)
    private String summary;
    @Column(name = "created_at",columnDefinition = "DATETIME")
    private Instant createdAt;
    @Column(name = "update_at",columnDefinition = "DATETIME")
    private Instant updateAt;
    @Column(name = "published_at",columnDefinition = "DATETIME")
    private Instant publishedAt;
    @Column(name = "title",columnDefinition = "VARCHAR(75)",nullable = true)
    private String title;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post parent;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Post> posts=new LinkedHashSet<>();
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<PostComment> postComments=new LinkedHashSet<>();
//ashk
}
