package edu.ucsb.cs56.w20.lab07.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.ucsb.cs56.w20.lab07.advice.AuthControllerAdvice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class HomePageTest {

    @Autowired
	private MockMvc mvc;

	@MockBean
	private AuthControllerAdvice aca;
	
	@MockBean
    private ClientRegistrationRepository crr;

    @Test
    public void getHomePage_ContentType() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }
 
    @Test
    public void getHomePage_hasCorrectTitle() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(xpath("//title").exists())
                .andExpect(xpath("//title").string("lab07-CS56"));
    }
    /*
    @Test
    public void getHomePage_hasUsersLink() throws Exception {
     mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
             .andExpect(status().isOk())
             .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[3]/a").exists())
             .andExpect(xpath("/html/body/div/nav/div/ul[1]/li[3]/a").string("Users"));
    }
    */
    
}
