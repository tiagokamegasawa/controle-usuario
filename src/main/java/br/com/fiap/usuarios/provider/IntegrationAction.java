package br.com.fiap.usuarios.provider;

import lombok.Getter;

public enum IntegrationAction {

  BALANCE_UPDATE("Balance update");

  @Getter
  private final String descrition;

  IntegrationAction(String descrition) {
    this.descrition = descrition;
  }
}
