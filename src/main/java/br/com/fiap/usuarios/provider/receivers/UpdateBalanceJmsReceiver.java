package br.com.fiap.usuarios.provider.receivers;

import br.com.fiap.usuarios.config.rest.RestControleColetaProperties;
import br.com.fiap.usuarios.entity.User;
import br.com.fiap.usuarios.service.UserService;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpdateBalanceJmsReceiver implements IntegrationMessageReceiver {

  @Autowired
  private RestTemplate template;

  @Autowired
  private RestControleColetaProperties properties;

  @Autowired
  private UserService userService;

  @Override
  public void receive(byte[] message) {
    Map<String, String> params = new HashMap<>();
    String cpfCnpj = new String(message, StandardCharsets.UTF_8);
    params.put("cpfCnpj", cpfCnpj);
    String urlFull = String.format("%s%s", properties.getUrl(), properties.getBalanceEndpoint());
    Double balance = template.getForObject(urlFull, Double.class, params);
    userService.updateBalance(cpfCnpj, balance);
  }
}
