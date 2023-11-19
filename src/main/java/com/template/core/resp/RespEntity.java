package com.template.core.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一响应基础类
 * @author xxl
 * @since 2023/9/16
 */
@Data
@Accessors(chain = true)
@Schema(description = "响应对象")
public  class RespEntity<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -3917323953100432259L;

    @Schema(description = "状态码")
    private int code;
    @Schema(description = "提示信息")
    private String message;
    @Schema(description = "返回数据")
    private T data;

    public RespEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RespEntity<T> base(int code, String message, T data) {
        return new RespEntity<T>(code, message,data);
    }
}
