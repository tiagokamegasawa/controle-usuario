package br.com.fiap.usuarios.repository.bank;

import br.com.fiap.usuarios.entity.Bank;

public interface BankCustomRepository {

  public Bank findByNumber(String number);
}
