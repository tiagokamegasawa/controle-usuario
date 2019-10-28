package br.com.fiap.usuarios.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER_SYSTEM")
public @Data
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CPF_CNPJ")
  private String cpfCnpj;

  @Column(name = "EMAIL")
  private String email;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Account> accounts = new HashSet<>();

  public void addAccount(Account account) {
    accounts.add(account);
  }
}
