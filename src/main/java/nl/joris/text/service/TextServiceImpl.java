package nl.joris.text.service;

import nl.joris.text.Text;
import nl.joris.text.repository.TextRepository;
import org.elasticsearch.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextRepository textRepository;

    @Override
    public List<Text> findAll() {

        return Lists.newArrayList(textRepository.findAll());
    }

    @Override
    public List<Text> findBySearchQuery(String searchQuery) {

        return textRepository.findByContentContainingOrTitleContaining(searchQuery, searchQuery);
    }

    @Override
    public Text findOne(String id) {

        return textRepository.findOne(id);
    }

    @Override
    public Text createText(Text text) {
        text.setCreatedOn(new Date());
        return textRepository.save(text);
    }

    @Override
    public Text updateText(Text text) {

        Assert.notNull(text.getId());

        return textRepository.save(text);
    }

    @Override
    public void removeText(String id) {

        Assert.notNull(id);

        textRepository.delete(id);
    }
}
