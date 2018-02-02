//package su.psergeev77.service.facade.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.mock.http.MockHttpOutputMessage;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//import su.psergeev77.service.post.PostServiceConfig;
//import su.psergeev77.service.post.model.Post;
//import su.psergeev77.service.post.repository.PostRepository;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//
///**
// * @author Josh Long
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PostServiceConfig.class)
//@WebAppConfiguration
//public class PostControllerTest {
//    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
//            MediaType.APPLICATION_JSON.getSubtype(),
//            Charset.forName("utf8"));
//
//    private MockMvc mockMvc;
//
//    private String userName = "bdussault";
//
//    private HttpMessageConverter mappingJackson2HttpMessageConverter;
//
//    private Post post;
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Autowired
//    void setConverters(HttpMessageConverter<?>[] converters) {
//
//        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
//                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
//                .findAny()
//                .orElse(null);
//
//        assertNotNull("the JSON message converter must not be null",
//                this.mappingJackson2HttpMessageConverter);
//    }
//
//    @Before
//    public void setup() throws Exception {
//        this.mockMvc = webAppContextSetup(webApplicationContext).build();
//
//        this.postRepository.deleteAllInBatch();
//
//        this.post = postRepository.save(new Post("jhoeller", "Test title", "Text 1"));
//    }
//
//    @Test
//    public void postNotFound() throws Exception {
//        mockMvc.perform(get("/post/1000")
//                .contentType(contentType))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void getPost() throws Exception {
//        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
//                "hal+json",
//                Charset.forName("utf8"));
//
//        mockMvc.perform(get("/post/" + post.getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.post.id", is(post.getId().intValue())))
//                .andExpect(jsonPath("$.post.userName", is(post.getUserName())))
//                .andExpect(jsonPath("$.post.title", is(post.getTitle())))
//                .andExpect(jsonPath("$.post.text", is(post.getText())))
//                .andExpect(jsonPath("$.post.date", is(post.getDate().getTime())));
//    }
//
//    @Test
//    public void createPost() throws Exception {
//        String postJson = json(new Post("testClienty", "TestTitle","TestText"));
//        this.mockMvc.perform(post("/post")
//                .contentType(contentType)
//                .content(postJson))
//                .andExpect(status().isCreated());
//    }
//
//    protected String json(Object o) throws IOException {
//        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
//        this.mappingJackson2HttpMessageConverter.write(
//                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
//        return mockHttpOutputMessage.getBodyAsString();
//    }
//}