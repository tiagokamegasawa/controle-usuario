package br.com.fiap.usuarios.repository.account;

import br.com.fiap.usuarios.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
