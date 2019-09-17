package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.dto.mapper.DevMapper;

public interface DeveloperService {
  // basic CRUD

  DevMapper mapper = DevMapper.INSTANCE;

  DeveloperDTO saveDev(DeveloperDTO dto);
  DeveloperDTO updateDev(DeveloperDTO dto);
  DeveloperDTO findDevById(Integer id);
  void deleteDev(DeveloperDTO dto);

}
