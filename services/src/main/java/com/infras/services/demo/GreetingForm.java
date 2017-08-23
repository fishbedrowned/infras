package com.infras.services.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Created by zhaoheng on 2017/7/15.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingForm {

    private String name;
    private Optional<Integer> age = Optional.empty();
}
