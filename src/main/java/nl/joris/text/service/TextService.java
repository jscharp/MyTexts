package nl.joris.text.service;

import nl.joris.text.Text;

import java.util.List;

public interface TextService {

    Iterable<Text> findAll();
    List<Text> findBySearchQuery(String searchQuery);

    Text createText(Text text);
    Text updateText(Text text);
    void removeText(Text text);
}
