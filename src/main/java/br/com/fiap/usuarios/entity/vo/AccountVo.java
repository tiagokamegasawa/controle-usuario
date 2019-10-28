package br.com.fiap.usuarios.entity.vo;

import lombok.Data;

public @Data class AccountVo {

  private String number;

  private String digit;

  private String agencyNumber;

  private String agencyDigit;

  private String numberBank;

  private Long userId;
}
