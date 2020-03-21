package com.leyou.item.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Cid3 implements Serializable {
    @ApiModelProperty(value = "父类目id,顶级类目填0")
    private Long parentId;

    private static final long serialVersionUID = 1L;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parentId=").append(parentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}