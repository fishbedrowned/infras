package com.infras.model.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by zhaoheng on 2017/11/7.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverLocation {
    @Id
    private Integer id;
    private Integer loginId;
    private Double longitude;
    private Double latitude;

    @Override
    public String toString() {
        return "id=" + id + " loginId=" + loginId + " longitude=" + longitude + "latitude=" + latitude;
    }
}
