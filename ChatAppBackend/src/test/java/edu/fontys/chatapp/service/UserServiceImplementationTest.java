package edu.fontys.chatapp.service;

import edu.fontys.chatapp.model.User;
import edu.fontys.chatapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class UserServiceImplementationTest {
    @Mock
    private UserRepository userRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getUsersTest() {
        //when
        userRepository.findAll();

        //then
        verify(userRepository).findAll();
    }

    @Test
    void saveUserTest() {
        //given
        User user = new User(null, "admin", "1234", "room1", new ArrayList<>(), new ArrayList<>());

        //when
        userRepository.save(user);

        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }
}
