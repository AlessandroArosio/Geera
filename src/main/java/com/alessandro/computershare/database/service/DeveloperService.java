package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dto.DeveloperDTO;

import java.util.List;

public interface DeveloperService {
  // basic CRUD

  DeveloperDTO saveDev(DeveloperDTO dto);
  DeveloperDTO updateDev(DeveloperDTO dto);
  DeveloperDTO findDevById(Integer id);
  List<DeveloperDTO> getAllDevs();
  void deleteDev(DeveloperDTO dto);

}
