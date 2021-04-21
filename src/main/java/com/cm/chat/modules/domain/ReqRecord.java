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
 * @TableName req_record
 */
@TableName(value ="req_record")
@Data
public class ReqRecord implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 发送方
     */
    @TableField(value = "send_user_id")
    private String sendUserId;

    /**
     * 接收方
     */
    @TableField(value = "accept_user_id")
    private String acceptUserId;

    /**
     * 请求时间
     */
    @TableField(value = "req_time")
    private Date reqTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}