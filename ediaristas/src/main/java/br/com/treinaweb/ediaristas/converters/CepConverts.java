package br.com.treinaweb.ediaristas.converters;

import jakarta.persistence.AttributeConverter;

public class CepConverts implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String cep) {
        return cep.replace("-", "");
    }

    @Override
    public String convertToEntityAttribute(String cep) {
        return cep;
    }
}
