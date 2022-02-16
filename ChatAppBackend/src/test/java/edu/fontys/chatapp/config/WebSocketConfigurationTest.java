package edu.fontys.chatapp.config;

import edu.fontys.chatapp.ChatAppBackend;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.concurrent.TimeUnit.SECONDS;

@SpringBootTest(classes = ChatAppBackend.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebSocketConfigurationTest {

	static final String WEBSOCKET_URI = "http://localhost:8080/sockjs";
	static final String WEBSOCKET_TOPIC = "/topic";

	BlockingQueue<String> blockingQueue;
	WebSocketStompClient webSocketStompClient;

	@BeforeEach
	public void setUp() {
		blockingQueue = new LinkedBlockingDeque<>();
		webSocketStompClient =
				new WebSocketStompClient(
				new SockJsClient(List.of(
				new WebSocketTransport(
				new StandardWebSocketClient()
		))));
	}

	@Test
	public void shouldReceiveMessageFromTheServer() throws Exception {
		StompSession session = webSocketStompClient
				.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {})
				.get(1, SECONDS);

		session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());

		String message = "test";
		session.send(WEBSOCKET_TOPIC, message.getBytes());

		Assertions.assertEquals(message, blockingQueue.poll(1, SECONDS));
	}

	class DefaultStompFrameHandler implements StompFrameHandler {
		@Override
		public Type getPayloadType(StompHeaders stompHeaders) {
			return byte[].class;
		}

		@Override
		public void handleFrame(StompHeaders stompHeaders, Object payload) {
			blockingQueue.offer(new String((byte[]) payload));
		}
	}
}