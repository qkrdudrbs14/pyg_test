package com.project.pyg.dao;

import com.project.pyg.dto.RestApiDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestApiDao extends JpaRepository<RestApiDto, String> {
}
