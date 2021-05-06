package com.cm.chat.modules.pojo.vo;

import com.cm.chat.modules.domain.CwUser;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName UserVo
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/30 11:04
 * @Version 1.0
 **/
@Getter
@Setter
@Accessors(chain = true)
public class UserVo {

    private String id;
    private String username;
    private String faceImg;
    private String faceImgBig;
    private String nickname;
    private String qrcode;

    public static UserVo getInstance(CwUser user){
        return new UserVo()
                .setUsername(user.getUsername())
                .setFaceImg(user.getFaceImg())
                .setId(user.getId())
                .setFaceImgBig(user.getFaceImgBig())
                .setNickname(user.getPassword())
                .setQrcode(user.getQrcode());
    }

}
