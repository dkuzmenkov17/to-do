package com.github.dkuzmenkov17.todo.dao.jpa;

import com.github.dkuzmenkov17.todo.domain.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity(name = "ToDo")
public class ToDoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatedDt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "UpdatedDt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;

    public ToDoJpaEntity() {
    }

    @PrePersist
    public void onSave() {
        Date currentDate = new Date();
        this.createdDt = currentDate;
        this.updatedDt = currentDate;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoJpaEntity that = (ToDoJpaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}