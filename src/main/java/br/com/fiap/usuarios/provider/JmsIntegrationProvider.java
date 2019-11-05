package br.com.fiap.usuarios.provider;


import br.com.fiap.usuarios.provider.receivers.IntegrationMessageReceiver;
import br.com.fiap.usuarios.provider.receivers.UpdateBalanceJmsReceiver;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsIntegrationProvider implements IntegrationProvider  {

  private Map<IntegrationAction, IntegrationMessageReceiver> integrationSenders = new HashMap<IntegrationAction, IntegrationMessageReceiver>();

  @Autowired
  private UpdateBalanceJmsReceiver balanceJmsReceiver;

  @PostConstruct
  public void init(){
    integrationSenders.put(IntegrationAction.BALANCE_UPDATE, balanceJmsReceiver);
  }

  @Override
  public IntegrationMessageReceiver getReceiver(IntegrationAction action){
    return integrationSenders.get(action);
  }
}
