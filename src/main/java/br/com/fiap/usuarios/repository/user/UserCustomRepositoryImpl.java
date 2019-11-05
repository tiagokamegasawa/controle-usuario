package br.com.fiap.usuarios.repository.user;

import br.com.fiap.usuarios.entity.User;
import br.com.fiap.usuarios.entity.vo.UserVo;
import br.com.fiap.usuarios.utils.QueryBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;

public class UserCustomRepositoryImpl implements UserCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public UserVo findByCpfCnpj(String cpfCnpj) {
    Map<String, Object> params = new HashMap<>();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT user.name as name, ");
    query.append(" user.cpfCnpj as cpfCnpj, ");
    query.append(" user.email as email, ");
    query.append(" user.balance as balance ");
    query.append(" FROM ").append(User.class.getCanonicalName());
    query.append(" as user ");
    query.append(" WHERE user.cpfCnpj = :cpfCnpj");

    params.put("cpfCnpj", cpfCnpj);

    Query execQuery = entityManager.createQuery(query.toString());
    execQuery.unwrap(org.hibernate.query.Query.class).setResultTransformer(new AliasToBeanResultTransformer(UserVo.class));
    QueryBuilder.bindParameters(execQuery, params);

    return (UserVo) execQuery.getSingleResult();
  }

  @Override
  public Boolean existWithCpfCnpjOrEmail(String cpfCnpj, String email) {
    Map<String, Object> params = new HashMap<>();

    StringBuilder query = new StringBuilder();
    query.append(" SELECT count(user.id) ");
    query.append(" FROM ").append(User.class.getCanonicalName());
    query.append(" AS user ");
    query.append(" WHERE user.cpfCnpj = :cpfCnpj");
    query.append(" OR ");
    query.append(" user.email = :email");

    params.put("cpfCnpj", cpfCnpj);
    params.put("email", email);

    Query execQuery = entityManager.createQuery(query.toString());
    QueryBuilder.bindParameters(execQuery, params);

    return (Long) execQuery.getSingleResult() > 0;
  }
}
