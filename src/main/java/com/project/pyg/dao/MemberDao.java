package com.project.pyg.dao;

import com.project.pyg.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberDto, String> {
}
