package com.cm.chat.modules.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cw_user
 */
@TableName(value ="cw_user")
@Data
public class CwUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户名称
     */
    @TableField(value = "username")
    private String username;

    /**
     * 加密后的密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 缩略图
     */
    @TableField(value = "face_img")
    private String faceImg;

    /**
     * 大图
     */
    @TableField(value = "face_img_big")
    private String faceImgBig;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 扫码
     */
    @TableField(value = "qrcode")
    private String qrcode;

    /**
     * 设备id
     */
    @TableField(value = "clent_id")
    private String clentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}