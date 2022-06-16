package edu.fontys.chatapp.controllers;

import edu.fontys.chatapp.models.User;
import edu.fontys.chatapp.repository.UserRepository;
import edu.fontys.chatapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.ArrayList;
import java.util.Objects;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void saveUserTest()
    {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        User user = new User(null, "admin", "1234", "room1", new ArrayList<>(), new ArrayList<>());

        //when
        userRepository.save(user);

        when(userService.saveUser(any(User.class))).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.saveUser(user);

        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(Objects.requireNonNull(responseEntity.getHeaders().getLocation()).getPath()).isEqualTo("/api/user/save");
    }
}
