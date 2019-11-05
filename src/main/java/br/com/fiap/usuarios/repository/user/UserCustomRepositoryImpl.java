package br.com.fiap.usuarios.repository.user;

import br.com.fiap.usuarios.entity.User;
import br.com.fiap.usuarios.entity.vo.UserVo;
import br.com.fiap.usuarios.utils.QueryBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserCustomRepositoryImpl implements UserCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public UserVo findByCpfCnpj(String cpfCnpj) {
    Map<String, Object> params = new HashMap<>();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT user.name as name, ");
    query.append(" user.cpfCnpj as cpfCnpj ");
    query.append(" user.email as email ");
    query.append(" FROM ").append(User.class.getCanonicalName());
    query.append(" as user ");
    query.append(" WHERE user.cpfCnpj = :cpfCnpj");

    params.put("cpfCnpj", cpfCnpj);

    Query execQuery = entityManager.createQuery(query.toString(), UserVo.class);
    QueryBuilder.bindParameters(execQuery, params);

    return (UserVo) execQuery.getSingleResult();
  }
}
