package com.alessandro.computershare.database.dto.mapper;

import com.alessandro.computershare.database.dto.DeveloperDTO;
import com.alessandro.computershare.database.entity.Developer;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DevMapperTest {

  DevMapper mapper = DevMapper.INSTANCE;

  // Need IntelliJ / Eclipse plugin to run Junit using MapStruct. Implementation is done during compile time
  @Ignore
  @Test
  public void entityToDtoTest() {

    // given
    Developer developer = new Developer();
    developer.setName("John");
    developer.setEmail("john@smith.com");
    developer.setId(44);

    // when
    DeveloperDTO dto = mapper.devToDTO(developer);

    // then
    assertEquals("John", dto.getName());
    assertEquals("john@smith.com", dto.getEmail());
    assertEquals(Integer.valueOf(44), dto.getId());
    assertNotNull(dto.getTaskList());
    assertEquals(0, dto.getTaskList().size());

  }

}