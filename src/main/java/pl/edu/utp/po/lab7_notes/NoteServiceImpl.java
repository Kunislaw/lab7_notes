package pl.edu.utp.po.lab7_notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepo noteRepo;
    @Override
    public void createNote(Note note){
        noteRepo.save(note);
    }
    @Override
    public void deleteNote(Note note){
        noteRepo.delete(note);
    }
    @Override
    public void updateNote(Long id, ImportanceEnum importanceEnum, String text){
        Note noteTemp = noteRepo.getOne(id);
        if(noteTemp != null){
            noteTemp.setImportance(importanceEnum);
            noteTemp.setText(text);
            noteRepo.save(noteTemp);
        }
    }
    @Override
    public List<Note> getNotes(){
        return noteRepo.findByOrderByTimestampDesc();
    }
    @Override
    public Note getNote(Long id){
        return noteRepo.findOneById(id);
    }
}
