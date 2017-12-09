package com.epam.course.store;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCustomer() throws Exception {
        mockMvc.perform(get("/customer/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testConfiguration() throws Exception{
        mockMvc.perform(get("/property/test"))
                .andExpect(content().string("CUSTOM-VALUE"));
    }

}
