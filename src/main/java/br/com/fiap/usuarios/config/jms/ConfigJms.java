package br.com.fiap.usuarios.config.jms;

import javax.jms.QueueConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ConfigJms {

  @Autowired
  private ActiveMQProperties properties;

  @Bean
  public QueueConnectionFactory connectionFactory() {
    if ( "".equals(properties.getUser()) ) {
      return new ActiveMQConnectionFactory(properties.getHost());
    }
    return new ActiveMQConnectionFactory(properties.getUser(), properties.getPassword(), properties.getHost());
  }
}