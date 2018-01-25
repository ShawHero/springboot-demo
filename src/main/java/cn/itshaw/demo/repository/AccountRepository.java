package cn.itshaw.demo.repository;

import cn.itshaw.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findById(long id);

}
