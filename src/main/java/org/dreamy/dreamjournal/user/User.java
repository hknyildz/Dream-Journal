package org.dreamy.dreamjournal.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "oauthProvider"}) // email+provider kombinasyonu unique
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    @Column(nullable = false)
    private String email;

    private String password; // sadece normal kullanıcılar için kullanılır (Google/Apple kullanmaz)

    private String oauthProvider; // "google", "apple", null olabilir
    private String oauthId;       // Google/Apple sub ID

    private String profileImage;


    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.lastLoginAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastLoginAt = LocalDateTime.now();
    }

    public enum Role {
        STANDARD, PREMIUM, ADMIN
    }
}




