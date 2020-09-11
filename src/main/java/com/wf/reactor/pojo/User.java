package com.wf.reactor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wf
 * @create 2020-09-10 22:28
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String gender;
    private Integer age;
}
