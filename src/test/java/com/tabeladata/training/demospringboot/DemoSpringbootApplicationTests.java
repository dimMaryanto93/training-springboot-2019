package com.tabeladata.training.demospringboot;

import com.tabeladata.training.demospringboot.entity.Agama;
import com.tabeladata.training.demospringboot.repository.AgamaRepository;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringbootApplicationTests extends TestCase{
    
    @Autowired
    private AgamaRepository repo;

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void testGetDataById(){
        Agama islam = repo.findById(1);
        
        assertNotNull(islam);
        assertEquals("ISLAm", islam.getName());
        
        List<Agama> list = repo.findAll();
        assertEquals(list.size(), 4);        
    }

}
