package su.psergeev77.service.client.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import su.psergeev77.service.client.ClientServiceConfig;
import su.psergeev77.service.client.model.Client;
import su.psergeev77.service.client.repository.ClientRepository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientServiceConfig.class)
@WebAppConfiguration
public class ClientControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private String userName = "bdussault";

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private Client client;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.clientRepository.deleteAllInBatch();

        this.client = clientRepository.save(new Client("jhoeller","Liam","Smith","jhoeller@gmail.com"));
    }

    @Test
    public void clientNotFound() throws Exception {
        mockMvc.perform(get("/client/george")
                .contentType(contentType))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getClient() throws Exception {
        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
                "hal+json",
                Charset.forName("utf8"));

        mockMvc.perform(get("/client/" + this.client.getUserName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.client.id", is(this.client.getId().intValue())))
                .andExpect(jsonPath("$.client.userName", is(this.client.getUserName())))
                .andExpect(jsonPath("$.client.email", is(this.client.getEmail())));
    }

    @Test
    public void createBookmark() throws Exception {
        String clientJson = json(new Client("dsyer","Emma","Johnson","dsyer1@yandex.ru"));
        this.mockMvc.perform(post("/client")
                .contentType(contentType)
                .content(clientJson))
                .andExpect(status().isCreated());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}