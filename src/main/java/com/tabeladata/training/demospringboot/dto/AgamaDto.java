/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot.dto;

import java.sql.Timestamp;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dimasm93
 */
public class AgamaDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AgamaNewRequest {

        @NotNull(message = "Namanya tidak boleh null")
        @NotEmpty(message = "Namanya tidak boleh kosong")
        @Size(min = 5, max = 50, message = "Nama harus memiliki 5 s/d 50 karakter")
        private String name;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AgamaUpdateRequest {

        @NotNull
        private Integer id;
        @NotNull
        @NotEmpty
        @Size(min = 5, max = 50)
        private String name;
        private String description;
        @NotNull
        private Timestamp createdDate;
        @NotNull
        @NotEmpty
        private String createdBy;
        private Timestamp lastUpdateDate;
        private String lastUpdateBy;
    }

}
