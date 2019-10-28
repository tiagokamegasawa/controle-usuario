package br.com.fiap.usuarios.repository.user;

import br.com.fiap.usuarios.entity.vo.UserVo;

public interface UserCustomRepository {

  UserVo findByCpfCnpj(String name);

}
