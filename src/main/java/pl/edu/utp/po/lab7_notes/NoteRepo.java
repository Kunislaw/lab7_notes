package pl.edu.utp.po.lab7_notes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note,Long> {
    List<Note> findByOrderByTimestampDesc();
    Note findOneById(Long id);
}
