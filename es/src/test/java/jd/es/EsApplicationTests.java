package jd.es;

import jd.es.service.ContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class EsApplicationTests {
@Autowired
private ContentService contentService;
    @Test
    void getJava() throws IOException {
        contentService.parseContent("java");
    }
//    @Test
//    void getLaptop() throws IOException {
//        contentService.parseContent("笔记本");
//    }
    @Test
    void getPython() throws IOException {
        contentService.parseContent("Python");
    }
}
