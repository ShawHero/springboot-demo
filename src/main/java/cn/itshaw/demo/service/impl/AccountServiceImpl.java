package cn.itshaw.demo.service.impl;

import cn.itshaw.demo.service.AccountService;
import cn.itshaw.demo.domain.Account;
import cn.itshaw.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository appRepository;

    @Override
    @Cacheable(value = "findById")
    public Account findById(long id) {
        return appRepository.findById(id);
    }

}
