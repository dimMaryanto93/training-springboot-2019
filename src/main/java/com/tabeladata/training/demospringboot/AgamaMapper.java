/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot;

import com.tabeladata.training.demospringboot.dto.AgamaDto;
import com.tabeladata.training.demospringboot.entity.Agama;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author dimasm93
 */
@Mapper
public interface AgamaMapper {
    
    AgamaMapper INSTANCE =  Mappers.getMapper(AgamaMapper.class);
    
    Agama convertToEntity(AgamaDto.AgamaNewRequest dto);  
    
    Agama convertToEntityUpdated(AgamaDto.AgamaUpdateRequest dto);
    
    AgamaDto.AgamaUpdateRequest convertToDto(Agama agama);
}
