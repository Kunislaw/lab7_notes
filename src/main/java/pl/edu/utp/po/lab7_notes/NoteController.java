package pl.edu.utp.po.lab7_notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "redirect:list";
    }

}
