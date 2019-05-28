package pl.edu.utp.po.lab7_notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllNotes(Model model){
        Note newNote = new Note();
        model.addAttribute("newNote",newNote);
        model.addAttribute("importances", ImportanceEnum.values());
        model.addAttribute("notes",noteService.getNotes());
        return "list";
    }
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String sendNewNote(@ModelAttribute(value="newNote") Note note){
        noteService.createNote(note);
        return "redirect:/list";
    }
    @RequestMapping(value = "/list/delete/{id}", method = RequestMethod.GET)
    public String deleteNote(@PathVariable Long id){
        Note deleteNote = noteService.getNote(id);
        noteService.deleteNote(deleteNote);
        return "redirect:/list";
    }
    @RequestMapping(value = "/list/edit/{id}", method = RequestMethod.GET)
    public String editNote(@PathVariable Long id, Model model){
        Note editNote = noteService.getNote(id);
        model.addAttribute("editNote", editNote);
        model.addAttribute("importances", ImportanceEnum.values());
        return "edit";
    }
    @RequestMapping(value = "/list/edit/{id}", method = RequestMethod.POST)
    public String sendEditNote(@PathVariable Long id, @ModelAttribute(value="editNote") Note note){
        noteService.updateNote(id, note.getImportance(),note.getText());
        return "redirect:/list";
    }

}
