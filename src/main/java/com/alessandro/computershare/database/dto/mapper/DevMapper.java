package com.alessandro.computershare.database.dto.mapper;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DevMapper {

  DevMapper INSTANCE = Mappers.getMapper(DevMapper.class);

  DeveloperDTO devToDTO(Developer developer);
  Developer dtoToDev(DeveloperDTO developerDTO);
}
