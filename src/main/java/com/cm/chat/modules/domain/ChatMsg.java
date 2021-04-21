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
 * @TableName chat_msg
 */
@TableName(value ="chat_msg")
@Data
public class ChatMsg implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 消息发送方
     */
    @TableField(value = "send_user_id")
    private String sendUserId;

    /**
     * 消息接收方
     */
    @TableField(value = "accept_user_id")
    private String acceptUserId;

    /**
     * 消息内容
     */
    @TableField(value = "msg")
    private String msg;

    /**
     * 是否已读
     */
    @TableField(value = "sign_status")
    private Boolean signStatus;

    /**
     * 发送时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}