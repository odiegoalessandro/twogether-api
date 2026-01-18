package com.twogether.demo.domain.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "relationships")
public class RelationshipEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "started_at")
  private LocalDate startedAt;

  @Column(name = "created_at")
  private Instant createdAt;

  public RelationshipEntity(UUID id, LocalDate startedAt, Instant createdAt) {
    this.id = id;
    this.startedAt = startedAt;
    this.createdAt = createdAt;
  }

  public UUID getId() {
    return id;
  }

  public LocalDate getStartedAt() {
    return startedAt;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }
}
