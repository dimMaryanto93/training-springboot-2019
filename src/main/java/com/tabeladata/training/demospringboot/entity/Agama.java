/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dimasm93
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agama {
    
    private Integer id;
    private String name;
    private String description;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp lastUpdateDate;
    private String lastUpdateBy;

  
    
}
