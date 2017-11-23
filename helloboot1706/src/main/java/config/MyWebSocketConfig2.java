package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class MyWebSocketConfig2 extends WebSocketConfigurationSupport {

    @Bean
    public WebSocketHandler handler() {
        return new MessageHandler();
    }

    @Override
    protected void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/otherEP").withSockJS();
    }
}
