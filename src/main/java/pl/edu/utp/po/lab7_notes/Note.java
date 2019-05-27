package pl.edu.utp.po.lab7_notes;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "importance", nullable = false)
    private ImportanceEnum importance;
    @Column(name = "text", nullable = false)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImportanceEnum getImportance() {
        return importance;
    }

    public void setImportance(ImportanceEnum importance) {
        this.importance = importance;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", importance=" + importance +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
    @PrePersist
    protected void onCreate() {
        timestamp = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        timestamp = new Date();
    }
}
