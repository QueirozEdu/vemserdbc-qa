package br.com.dbccompany.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties

public class NoPageDTO {

    private String message;
    private String code;
    private String type;

}
