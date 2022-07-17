package com.project.pyg.dao;

import com.project.pyg.dto.SoundDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundDao extends JpaRepository<SoundDto, Integer> {
}
