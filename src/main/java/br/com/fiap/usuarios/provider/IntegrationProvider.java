package br.com.fiap.usuarios.provider;

import br.com.fiap.usuarios.provider.receivers.IntegrationMessageReceiver;

public interface IntegrationProvider {

  IntegrationMessageReceiver getReceiver(IntegrationAction action);
}
