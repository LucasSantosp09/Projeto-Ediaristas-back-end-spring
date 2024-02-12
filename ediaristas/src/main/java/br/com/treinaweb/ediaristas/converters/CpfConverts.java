package br.com.treinaweb.ediaristas.converters;

import jakarta.persistence.AttributeConverter;

public class CpfConverts implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String cpf) {
        return cpf.replaceAll("[.-]", "" );
    }

    @Override
    public String convertToEntityAttribute(String cpf) {
        return cpf;
    }
}
