package com.extra.websocket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private Integer id;
    private String systemNumber;
    private String username;
    private String password;
    private Boolean activeStatus;

}
