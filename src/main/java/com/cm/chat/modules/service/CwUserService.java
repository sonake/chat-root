package com.cm.chat.modules.service;

import com.cm.chat.modules.domain.CwUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface CwUserService extends IService<CwUser> {


    /**
     * @param username
     * @return
     */
    boolean userExist(String username);

    boolean login(String username,String password);

}
