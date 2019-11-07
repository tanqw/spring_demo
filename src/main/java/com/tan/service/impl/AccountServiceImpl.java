package com.tan.service.impl;

import com.tan.dao.AccountDao;
import com.tan.dao.impl.AccountDaoImpl;
import com.tan.factory.BeanFactory;
import com.tan.service.AccountService;

/*账户的业务层实现类*/
public class AccountServiceImpl implements AccountService {
//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
