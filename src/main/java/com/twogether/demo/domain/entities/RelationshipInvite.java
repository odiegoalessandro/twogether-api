package com.twogether.demo.domain.entities;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.aspectj.asm.internal.Relationship;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "relationship_invites")
public class RelationshipInvite {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "relationship_id", nullable = false)
  @Column(name = "relationship_id", nullable = false)
  private Relationship relationship;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inviter_id", nullable = false)
  @Column(name = "inviter_id", nullable = false)
  private User inviter;

  @Column(name = "token", nullable = false, unique = true)
  private String token;

  @Column(name = "expires_at", nullable = false)
  private Instant expiresAt;

  @Column(name = "used_at")
  private Instant usedAt;
}
