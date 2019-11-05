package br.com.fiap.usuarios.provider.receivers;

public interface IntegrationMessageReceiver {

  void receive(byte[] message);

}
