package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dao.DeveloperRepository;
import com.alessandro.computershare.database.dto.DeveloperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService {

  @Autowired
  private DeveloperRepository repository;

  @Override
  public DeveloperDTO saveDev(DeveloperDTO dto) {
    var developer = mapper.dtoToDev(dto);
    var persistedDev = repository.save(developer);
    return mapper.devToDTO(persistedDev);
  }

  @Override
  public DeveloperDTO updateDev(DeveloperDTO dto) {
    // seems identical to the one above, but hibernate is smarter (than me)
    var developer = mapper.dtoToDev(dto);
    var persistedDev = repository.save(developer);
    return mapper.devToDTO(persistedDev);
  }

  @Override
  public DeveloperDTO findDevById(Integer id) {
    return null;
  }

  @Override
  public void deleteDev(DeveloperDTO dto) {

  }
}
