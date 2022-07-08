package com.project.pyg.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "restdata")
public class RestApiDto {

    @Id
    private String user_id;

    private Double contents1;

    private Double contents2;

    private Timestamp reg_dt;

    private Timestamp upt_dt;

}
