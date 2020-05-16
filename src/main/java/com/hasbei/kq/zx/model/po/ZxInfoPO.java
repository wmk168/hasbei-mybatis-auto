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
 * 资讯信息
 * </p>
 *
 * @author weiminke
 * @date 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zx_info")
public class ZxInfoPO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资讯分类ID
     */
    private Long cateId;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 简介
     */
    private String description;

    /**
     * 图片,多张以“;”隔开
     */
    private String imgs;

    /**
     * 图片数量
     */
    private Integer imgsCount;

    /**
     * 资讯等级:10普通,20:专家,30:协会
     */
    private Integer level;

    /**
     * 资讯类型:0未知,10文本,20图文,30:视频
     */
    private Integer type;

    /**
     * 来源ID
     */
    private Long sourceId;

    /**
     * 来源名称
     */
    private String sourceName;

    /**
     * 来源网址
     */
    private String sourceWeb;

    /**
     * 作者ID
     */
    private Long authorId;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 状态:0早稿，1上架，-1下架，2审核中
     */
    private Integer status;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 下架时间
     */
    private LocalDateTime downTime;

    /**
     * 自营:0否，1是
     */
    private Integer selfType;

    /**
     * 推荐：0否，1是
     */
    private Integer recType;

    /**
     * 置顶：0否，1是
     */
    private Integer topType;

    /**
     * 浏览次数
     */
    private Integer lookCount;

    /**
     * 评论条数
     */
    private Integer commentCount;

    /**
     * 收藏人数
     */
    private Integer collectCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
