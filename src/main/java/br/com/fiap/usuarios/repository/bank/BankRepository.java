package br.com.fiap.usuarios.repository.bank;

import br.com.fiap.usuarios.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long>, BankCustomRepository {
}
