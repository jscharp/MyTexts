package nl.joris.text.controller;

import nl.joris.text.Text;
import nl.joris.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("text")
public class TextController {

    @Autowired
    private TextService textService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Text> findAll() {
        return textService.findAll();
    }

    @RequestMapping(value = "search/{searchQuery}/", method = RequestMethod.GET)
    public List<Text> searchText(@PathVariable String searchQuery) {
        return textService.findBySearchQuery(searchQuery);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Text findAll(@PathVariable String id) {
        return textService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Text createText(@RequestBody Text text) {
        return textService.createText(text);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Text updateText(@RequestBody Text text) {
        return textService.updateText(text);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void updateText(@PathVariable String id) {
        textService.removeText(id);
    }

}
