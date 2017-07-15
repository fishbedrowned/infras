package com.infras.model.demo;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * Created by zhaoheng on 2017/7/6.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    private Integer id;
    private String name;
    private Integer age;
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
