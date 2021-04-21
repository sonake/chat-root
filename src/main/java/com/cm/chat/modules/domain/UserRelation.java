package com.cm.chat.modules.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_relation
 */
@TableName(value ="user_relation")
@Data
public class UserRelation implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 主态用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 关系状态1正常2主态删除客态3客态删除主态
     */
    @TableField(value = "relation_status")
    private Boolean relationStatus;

    /**
     * 朋友id
     */
    @TableField(value = "friend_user_id")
    private String friendUserId;

    /**
     * 
     */
    @TableField(value = "contact_build_time")
    private Date contactBuildTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}