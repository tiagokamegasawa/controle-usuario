package br.com.fiap.usuarios.repository.user;

import br.com.fiap.usuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

  User cpfCnpj(String cpfCnpj);
}
