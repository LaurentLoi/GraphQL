package be.bstorm.formation.iris.graphql.model.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {
    protected LocalDate createdAt;
    protected LocalDate updatedAt;
    protected boolean isActive;

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public BaseEntity setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public BaseEntity setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public BaseEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    @PrePersist
    public void initCreatedAt() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.isActive = true;
    }

    @PreUpdate
    public void updateLifecycle() {
        this.updatedAt = LocalDate.now();
    }
}
