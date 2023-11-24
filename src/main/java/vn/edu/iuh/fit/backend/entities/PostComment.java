package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="post_comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "published",columnDefinition = "TINYINT(1)",nullable = true)
    private boolean published;
    @Column(name = "content",columnDefinition = "TEXT",nullable = false)
    private String content;
    @Column(name = "meta_title",columnDefinition = "VARCHAR(100)",nullable = true)
    private String metaTitle;
    @Column(name = "summary",columnDefinition = "TINYTEXT",nullable = true)
    private String summary;
    @Column(name = "created_at",columnDefinition = "DATETIME",nullable = true)
    private Instant createdAt;
    @Column(name = "updateAt",columnDefinition = "DATETIME",nullable = true)
    private Instant updateAt;
    @Column(name = "published_at",columnDefinition = "DATETIME",nullable = true)
    private Instant publishedAt;
    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
  private User user;
    @ManyToOne
    @JoinColumn(name = "parent_id",nullable = true)
    private PostComment parent;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments=new LinkedHashSet<>();
    public void addChildComment(PostComment postComment) {
        this.postComments.add(postComment);
        postComment.setParent(this);
   }
}
