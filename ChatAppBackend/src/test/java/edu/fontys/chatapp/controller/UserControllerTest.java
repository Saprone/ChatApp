package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import edu.fontys.chatapp.repository.UserRepository;
import edu.fontys.chatapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

@Slf4j
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    @Test
    void saveUserTest()
    {
        //given
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user = new User(null, "admin", "1234", "room1", new ArrayList<>(), new ArrayList<>());

        //when
        when(userService.saveUser(any(User.class))).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.saveUser(user);

        //then
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(Objects.requireNonNull(responseEntity.getHeaders().getLocation()).getPath()).isEqualTo("/api/user/save");
    }
}
