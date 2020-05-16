package com.hasbei.kq.zx.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资讯分类
 * </p>
 *
 * @author weiminke
 * @date 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zx_cate")
public class ZxCatePO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 状态:0禁用，1启用
     */
    private Integer status;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
