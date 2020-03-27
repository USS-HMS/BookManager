package com.blhx.book_managers.model;

import lombok.Data;

import java.util.Date;
@Data
public class Ticket {
    private int id;
//    相绑定的userId
    private int userId;
//    t票实体
    private String ticket;
//    国期时间
    private Date expiredAt;

}
