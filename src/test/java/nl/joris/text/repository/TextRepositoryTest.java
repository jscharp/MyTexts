package nl.joris.text.repository;


import nl.joris.text.MyTextsApplication;
import nl.joris.text.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyTextsApplication.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TextRepositoryTest {

    @Autowired
    private TextRepository textRepository;

    @Before
    public void init() {
        textRepository.deleteAll();
    }

    @Test
    public void testFindByContentContains() {
        Text textThatShouldBeFound = new Text();

        textThatShouldBeFound.setTitle("title");
        textThatShouldBeFound.setContent("Some content I can search on..");
        textRepository.save(textThatShouldBeFound);

        Text irrelevantText = new Text();
        irrelevantText.setTitle("So very irrelevant!");
        irrelevantText.setContent("Nobody wants me ;(");
        textRepository.save(irrelevantText);

        List<Text> foundText = textRepository.findByContentContainingOrTitleContaining("tent", "tent");

        assertEquals("The text should be found", 1, foundText.size());
        assertEquals("Should match the expected text", textThatShouldBeFound, foundText.get(0));

    }
}
