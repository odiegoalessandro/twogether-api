package com.twogether.demo.domain.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "relationship_members")
public class RelationshipMemberEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "relationship_id", nullable = false)
  private RelationshipEntity relationship;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", nullable = false)
  private UserEntity user;

  public RelationshipMemberEntity(UUID id, RelationshipEntity relationship, UserEntity user) {
    this.id = id;
    this.relationship = relationship;
    this.user = user;
  }

  public UUID getId() {
    return id;
  }

  public RelationshipEntity getRelationship() {
    return relationship;
  }

  public UserEntity getUser() {
    return user;
  }
}
