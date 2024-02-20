package DayPlanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "exp_date", nullable = false)
    private LocalDate expDate;

    @Column(name = "is_done", nullable = false)
    private boolean isDone;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    public Task(String taskName, LocalDate creationDate, LocalDate expDate, boolean isDone, String description, Challenge challenge) {
        this.taskName = taskName;
        this.creationDate = creationDate;
        this.expDate = expDate;
        this.isDone = isDone;
        this.description = description;
        this.challenge = challenge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
