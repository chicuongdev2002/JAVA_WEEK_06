package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="mobile",columnDefinition = "VARCHAR(15)")
    private String mobile;
    private Instant lastLogin;
    @Column(name="last_name",columnDefinition = "VARCHAR(50)")
    private String lastName;
    @Column(name="intro",columnDefinition = "TINYTEXT")
    private String intro;
    @Column(name="profile",columnDefinition = "TEXT")
    private String profile;
    private Instant registeredAt;
    @Column(name="password_hash",columnDefinition = "VARCHAR(15)")
   private String passwordHash;
    @Column(name="middle_name",columnDefinition = "VARCHAR(50)")
   private String middleName;
    @Column(name="first_name",columnDefinition = "VARCHAR(50)")
   private String firstName;
    @Column(name="email",columnDefinition = "VARCHAR(50)")
   private String email;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<PostComment> comments;
    @OneToMany(mappedBy="author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Post> posts;
}
