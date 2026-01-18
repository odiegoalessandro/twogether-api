package com.twogether.demo.domain.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(name = "password_hash", unique = true, nullable = false)
  private String passwordHash;

  @Column(nullable = false, unique = true)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, unique = false, columnDefinition = "role VARCHAR(30) default 'ROLE_USER'")
  private UserRoles role;

  @Column(nullable = false, name = "created_at")
  private Instant createdAt;

  public UserEntity(UUID id, String username, String passwordHash, String email, UserRoles role, Instant createdAt) {
    this.id = id;
    this.username = username;
    this.passwordHash = passwordHash;
    this.email = email;
    this.role = role;
    this.createdAt = createdAt;
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public String getEmail() {
    return email;
  }

  public UserRoles getRole() {
    return role;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }
}
