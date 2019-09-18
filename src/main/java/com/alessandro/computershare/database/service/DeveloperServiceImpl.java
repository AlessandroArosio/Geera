package com.alessandro.computershare.database.service;

import com.alessandro.computershare.database.dao.DeveloperRepository;
import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.dto.mapper.DevMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {

  @Autowired
  private DeveloperRepository repository;

  @Autowired
  private DevMapper mapper;

  @Override
  public DeveloperDTO saveDev(DeveloperDTO dto) {
    var developer = mapper.dtoToDev(dto);
    var persistedDev = repository.save(developer);
    return mapper.devToDTO(persistedDev);
  }

  @Override
  public DeveloperDTO updateDev(DeveloperDTO dto) {
    // seems identical to the one above, but hibernate is smarter (than me)
    if (repository.findById(dto.getId()).isPresent()) {
      var developer = mapper.dtoToDev(dto);
      var persistedDev = repository.save(developer);
      return mapper.devToDTO(persistedDev);
    } else {
      throw new RuntimeException();
    }
  }

  @Override
  public DeveloperDTO findDevById(Integer id) {
    var devFromDB = repository.findById(id);
    return mapper.devToDTO(devFromDB.orElseThrow(RuntimeException::new));
  }

  @Override
  public List<DeveloperDTO> getAllDevs() {
    return repository.findAll().stream().map(mapper::devToDTO).collect(Collectors.toList());
  }

  @Override
  public void deleteDevById(Integer id) {
    repository.deleteById(id);
  }
}
