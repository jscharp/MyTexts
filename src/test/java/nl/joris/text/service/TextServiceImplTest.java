package nl.joris.text.service;

import nl.joris.text.Text;
import nl.joris.text.repository.TextRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TextServiceImplTest {

    @InjectMocks
    private TextServiceImpl textService;

    @Mock
    private TextRepository textRepository;

    @Test
    public void testFindAll() throws Exception {

        when(textRepository.findAll())
                .thenReturn(new ArrayList<>());

        textService.findAll();

        verify(textRepository).findAll();
    }

    @Test
    public void testFindBySearchQuery() throws Exception {

        String searchQuery = "searchQuery";
        textService.findBySearchQuery(searchQuery);

        verify(textRepository).findByContentContaining(eq(searchQuery));
    }

    @Test
    public void testCreateText() throws Exception {
        Text newText = new Text();
        textService.createText(newText);

        verify(textRepository).save(eq(newText));
    }

    @Test
    public void testUpdateText() throws Exception {
        Text newText = new Text();
        newText.setId("someId");

        textService.updateText(newText);

        verify(textRepository).save(eq(newText));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTextWithoutId() throws Exception {
        Text newText = new Text();

        textService.updateText(newText);
    }

    @Test
    public void testRemoveText() throws Exception {
        Text text = new Text();
        text.setId("someId");

        textService.removeText(text);

        verify(textRepository).delete(eq(text));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTextWithoutId() throws Exception {
        Text newText = new Text();

        textService.removeText(newText);
    }
}