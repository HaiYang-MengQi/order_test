package org.haiyang.orderdemo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <E> Results<E> ok(E data){
        return new Results<>(200,"success",data);
    }
    public static <E> Results<E> error(E data){
        return new Results<>(400,"error",data);
    }
}
