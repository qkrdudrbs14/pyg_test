package com.project.pyg.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@Table(name = "tm_stext")
public class SoundDto {

    @Id
    private int sl_id;

    private String stext;
}
