package edu.fontys.chatapp.config;

import edu.fontys.chatapp.ChatAppBackend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@SpringBootTest(classes = ChatAppBackend.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebSocketConfigurationTest {

	static final String WEBSOCKET_URI = "http://localhost:8080/sockjs";
	static final String WEBSOCKET_TOPIC = "/topic";

	BlockingQueue<String> blockingQueue;
	WebSocketStompClient stompClient;

	@BeforeAll
	public void setUp() {
		blockingQueue = new LinkedBlockingDeque<>();
		stompClient =
				new WebSocketStompClient(
				new SockJsClient(List.of(
				new WebSocketTransport(
				new StandardWebSocketClient()
		))));
	}

	@Test
	public void shouldReceiveAMessageFromTheServer() throws Exception {
		StompSession session = stompClient.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {}).get();
	}
}