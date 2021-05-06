package com.cm.chat.modules.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cm.chat.modules.domain.CwUser;
import com.cm.chat.modules.service.CwUserService;
import com.cm.chat.modules.mapper.CwUserMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 *
 */
@Service
public class CwUserServiceImpl extends ServiceImpl<CwUserMapper, CwUser>
        implements CwUserService {

    @Override
    public boolean userExist(String username) {
        LambdaQueryWrapper<CwUser> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(StrUtil.isNotBlank(username),CwUser::getUsername,username);
        CwUser user =getOne(queryWrapper);
        return ObjectUtil.isNotNull(user);
    }

    @Override
    public boolean login(String username, String password) {
        LambdaQueryWrapper<CwUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StrUtil.isNotBlank(username),CwUser::getUsername,username)
                .eq(StrUtil.isNotBlank(password),CwUser::getPassword, SecureUtil.des(username.getBytes(StandardCharsets.UTF_8)).decryptStr(password));
        CwUser user = getOne(queryWrapper);
        return ObjectUtil.isNotNull(user);
    }

}




