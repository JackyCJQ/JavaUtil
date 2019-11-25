package com.jacky.log;

import lombok.Data;

/**
 * @auther
 */
@Data
public class CardParam {
    private String userId;
    private String cityCode;
    private Double longitude;
    private Double latitude;
    private String platform;
    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", platform='" + platform + '\'' +
                '}';
    }
}
