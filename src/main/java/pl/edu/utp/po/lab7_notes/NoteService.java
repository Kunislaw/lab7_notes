package pl.edu.utp.po.lab7_notes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    public void createNote(Note note);
    public void updateNote(Note note, ImportanceEnum importanceEnum, String text);
    public void deleteNote(Note note);
    public List<Note> getNotes();
}
