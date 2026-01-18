CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE relationships (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    started_at DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE relationship_members (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    relationship_id UUID NOT NULL,
    user_id UUID NOT NULL,

    UNIQUE (relationship_id, user_id),
    UNIQUE (user_id),

    FOREIGN KEY (relationship_id) REFERENCES relationships(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_relationship_members_user_id
ON relationship_members(user_id);

CREATE INDEX idx_relationship_members_relationship_id
ON relationship_members(relationship_id);
