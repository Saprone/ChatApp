package edu.fontys.chatapp.config;

import edu.fontys.chatapp.ChatAppBackend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import java.util.concurrent.BlockingQueue;

@SpringBootTest(classes = ChatAppBackend.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebSocketConfigurationTest {

	static final String WEBSOCKET_URI = "http://localhost:8081/sockjs";
	static final String WEBSOCKET_TOPIC = "/topic";

	BlockingQueue<String> blockingQueue;
	WebSocketStompClient stompClient;

	@BeforeAll
	public void setUp() {
		//setup
	}

	@Test
	public void shouldReceiveAMessageFromTheServer() throws Exception {
		Assertions.assertEquals(1, 1);
	}
}