package com.hasbei.kq.zx.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 资讯信息内容
 * </p>
 *
 * @author weiminke
 * @date 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zx_info_content")
public class ZxInfoContentPO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 资讯ID
     */
    private Long infoId;

    /**
     * 资讯内容
     */
    private String content;


}
