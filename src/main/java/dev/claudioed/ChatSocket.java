package dev.claudioed;

import io.quarkiverse.langchain4j.ChatMemoryRemover;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.logging.Logger;
import org.eclipse.microprofile.context.ManagedExecutor;

@ServerEndpoint(value = "/chat")
public class ChatSocket {

    private final CreditAnalystAgent agent;

    private final ManagedExecutor managedExecutor;

    public ChatSocket(CreditAnalystAgent agent, ManagedExecutor managedExecutor) {
        this.agent = agent;
        this.managedExecutor = managedExecutor;
    }
    @OnMessage
    public void onMessage(Session session, String userMessage) throws Exception {
        if (userMessage.equalsIgnoreCase("_ready_")) {
            return;
        }

        // we need to use a worker thread because OnMessage always runs on the event loop
        managedExecutor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    session.getBasicRemote().sendText("[User]: " + userMessage);
                    session.getBasicRemote().sendText("[Agent]: " + agent.chat(session, userMessage));
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                } catch (Exception e) {
                  throw new RuntimeException(e);
                }
            }
        });
    }

    @OnClose
    void onClose(Session session) {
        ChatMemoryRemover.remove(agent, session);
    }

}
