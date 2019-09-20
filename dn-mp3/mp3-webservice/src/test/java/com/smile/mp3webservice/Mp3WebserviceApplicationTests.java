package com.smile.mp3webservice;

import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.UserService;
import com.smile.mp3service.service.impl.SingerServiceImpl;
import com.smile.mp3service.service.impl.UserServiceImpl;
import com.smile.mp3webservice.controller.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mp3WebserviceApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

//    @Autowired
//    public UserServiceImpl userService;

    @InjectMocks
    public UserServiceImpl userServiceImpl;

    @Mock
    public UserService userService;

    @MockBean
    public UserRepository userRepository;

    @InjectMocks
    private UserController userController;

//    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
//    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkAge(){
        when(userRepository.findById(2)).thenReturn(Optional.of(new User(2, "Nguyen Phu Thang", 1, "male", "+84838247247", "nguyen2phuthang73@gmail.com", "lalala","pass", false)));
        assertEquals("Nguyen Phu Thang",userServiceImpl.getUser(2).getName());
    }

    @Test
    public void  getUser(){
        when(userRepository.findAll()).thenReturn(Stream.of(new User(2, "Nguyen Phu Thang", 0, "male", "+84838247247", "nguyen2phuthang73@gmail.com", "lalala","pass",false)).collect(Collectors.toList()));
        assertEquals(1,userServiceImpl.getUsers().size());
    }

//    @Test
//    public void testList()throws Exception{
//        List<User> mylist = new ArrayList<User>();
//        mylist.add(new User(2, "Nguyen Phu Thang", 1, "male", "+84838247247", "nguyen2phuthang73@gmail.com", "lalala","pass", false));
//        mylist.add(new User(3, "Nguyen Phu Thang2", 4, "male", "+84838247247", "nguye2n2phuthang73@gmail.com", "lal22ala","pass", false));
//        when(userServiceImpl.getUsers()).thenReturn((List) mylist);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/admin")
//                .accept(MediaType.APPLICATION_JSON);
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(view().name("/admin"))
//                .andExpect(model().attribute("mylist", hasSize(2)));
//    }

//    @Test
//    public void testRegister_returnsNewUser() {
//        User listMock = Mockito.mock(User.class);
//        when(listMock.sa(anyString())).thenReturn(false);
//
//        boolean added = listMock.add(randomAlphabetic(6));
//        assertThat(added, is(false));
//    }

//    @Test
//    public void testPostNewEntity() throws Exception {
//        User account = new User(2, "Nguyen Phu Thang", 1, "male", "+84838247247", "nguyen2phuthang73@gmail.com", "lalala","pass", false);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/register")
//                .content(ClassToStringUtils.parse(account)).contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(HttpStatus.CREATED.value()))
//                .andReturn();
//    }
}
