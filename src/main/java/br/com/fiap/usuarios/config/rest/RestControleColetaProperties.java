package br.com.fiap.usuarios.config.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rest.controle.coleta")
public @Data class RestControleColetaProperties {

  private String url;

  private String balanceEndpoint;

}
