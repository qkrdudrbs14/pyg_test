package com.project.pyg.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@ToString
@Table(name = "members")
public class MemberDto {

    @Id
    private String user_id;

    private String username;

    private String password;

    private Timestamp created_on;

    private String role;

}
