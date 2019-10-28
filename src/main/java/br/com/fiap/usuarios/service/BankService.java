package br.com.fiap.usuarios.service;

import br.com.fiap.usuarios.entity.Bank;
import br.com.fiap.usuarios.repository.bank.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

  @Autowired
  private BankRepository repository;

  public Bank findBankByNumber(String bankNumber) {
    return repository.findByNumber(bankNumber);
  }
}
