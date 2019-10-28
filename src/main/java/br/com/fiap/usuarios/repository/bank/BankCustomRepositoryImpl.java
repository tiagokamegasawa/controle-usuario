package br.com.fiap.usuarios.repository.bank;

import br.com.fiap.usuarios.entity.Bank;
import br.com.fiap.usuarios.entity.vo.UserVo;
import br.com.fiap.usuarios.utils.QueryBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BankCustomRepositoryImpl implements BankCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Bank findByNumber(String number) {
    Map<String, Object> params = new HashMap<>();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT bank ");
    query.append(" FROM Bank bank ");
    query.append(" WHERE bank.number = :number ");

    params.put("number", number);

    Query execQuery = entityManager.createQuery(query.toString(), Bank.class);
    QueryBuilder.bindParameters(execQuery, params);

    return (Bank) execQuery.getSingleResult();
  }
}
