package com.example.notes.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @SequenceGenerator(name = "note_sequence", sequenceName = "note_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "note")
    private String note;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    public Note() {
    }

    public Note(final long id, final User user, final String title, final String note, final LocalDateTime createdTime, final LocalDateTime updatedTime) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.note = note;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime creatLocalDateTime) {
        this.createdTime = creatLocalDateTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updateLocalDateTime) {
        this.updatedTime = updateLocalDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Note note1 = (Note) o;

        return new EqualsBuilder().append(getId(), note1.getId()).append(getUser(), note1.getUser()).append(getTitle(), note1.getTitle()).append(getNote(), note1.getNote()).append(getCreatedTime(), note1.getCreatedTime()).append(getUpdatedTime(), note1.getUpdatedTime()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getUser()).append(getTitle()).append(getNote()).append(getCreatedTime()).append(getUpdatedTime()).toHashCode();
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", creatLocalDateTime=" + createdTime +
                ", updateLocalDateTime=" + updatedTime +
                '}';
    }
}
