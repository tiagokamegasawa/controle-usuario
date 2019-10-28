package br.com.fiap.usuarios.entity.vo;

import lombok.Data;

public @Data class UserVo {

  private Long id;

  private String name;

  private String cpfCnpj;

  private String email;

}
