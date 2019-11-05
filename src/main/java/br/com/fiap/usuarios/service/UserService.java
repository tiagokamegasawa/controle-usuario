package br.com.fiap.usuarios.service;

import br.com.fiap.usuarios.entity.Account;
import br.com.fiap.usuarios.entity.User;
import br.com.fiap.usuarios.entity.vo.AccountVo;
import br.com.fiap.usuarios.entity.vo.UserVo;
import br.com.fiap.usuarios.repository.user.UserRepository;
import br.com.fiap.usuarios.validator.UserValidator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserValidator validator;

  @Autowired
  private AccountService accountService;

  public User createUser(UserVo userVo) {
    User user = new User();
    user.setName(userVo.getName());
    user.setCpfCnpj(userVo.getCpfCnpj());
    user.setEmail(userVo.getEmail());
    validator.validateInsert(user);
    return repository.save(user);
  }

  public UserVo findUserbyCpfCnpj(String cpfCnpj) {
    return repository.findByCpfCnpj(cpfCnpj);
  }

  public Account addAccountToUser(AccountVo accountVo) {
    User user = this.findById(accountVo.getUserId());
    Account account = accountService.createAccount(accountVo);
    user.addAccount(account);
    repository.save(user);
    return account;
  }

  private User findById(Long userId) {
    Optional<User> optional = repository.findById(userId);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new RuntimeException("User not found");
  }

  public void updateBalance(String cpfCnpj, Double balance) {
    User user =  this.repository.cpfCnpj(cpfCnpj);
    user.setBalance(balance);
    repository.save(user);
  }
}
