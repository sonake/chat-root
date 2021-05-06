package com.cm.chat.modules;

import cn.hutool.core.util.StrUtil;
import com.cm.chat.common.result.R;
import com.cm.chat.common.result.Rs;
import com.cm.chat.modules.domain.CwUser;
import com.cm.chat.modules.pojo.vo.UserVo;
import com.cm.chat.modules.service.CwUserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/29 20:16
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    final CwUserService userService;


    @PostMapping("/registerOrLogin")
    public R registerOrLogin(@RequestBody CwUser user){
        if(StrUtil.hasEmpty(user.getUsername(),user.getPassword())){
            return Rs.failure("用户名或密码错误!");
        }
        if(userService.userExist(user.getUsername())){
            //登录
            if(userService.login(user.getUsername(), user.getPassword())){
                return Rs.success("登陆成功");
            }
        }else {
            //注册
            CwUser cwUser = CwUser.userDefault(user.getUsername(),user.getPassword());
            int result = userService.getBaseMapper().insert(cwUser);
            if(result>0){
                UserVo vo = new UserVo();
                BeanUtils.copyProperties(cwUser,vo);
                return Rs.success("注册成功", vo);
            }
        }
        return Rs.failure("失败");
    }
}
