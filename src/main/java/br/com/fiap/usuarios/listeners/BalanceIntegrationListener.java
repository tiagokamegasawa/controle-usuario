package br.com.fiap.usuarios.listeners;

import br.com.fiap.usuarios.provider.IntegrationAction;
import br.com.fiap.usuarios.provider.IntegrationProvider;
import br.com.fiap.usuarios.provider.receivers.IntegrationMessageReceiver;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class BalanceIntegrationListener {

  @Autowired
  private IntegrationProvider integrationProvider;

  @JmsListener(destination = "${controle.usuario.activemq.fromUpdateBalanceQueue}")
  public void receiver(Message<String> message) {
    IntegrationMessageReceiver receiver = integrationProvider.getReceiver(IntegrationAction.BALANCE_UPDATE);
    receiver.receive(message.getPayload().getBytes(StandardCharsets.UTF_8));
  }
}
