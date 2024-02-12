package br.com.treinaweb.ediaristas.converters;

import jakarta.persistence.AttributeConverter;

public class TelefoneConverts implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String telefone) {
        return telefone.replaceAll("[() -]", "");
    }

    @Override
    public String convertToEntityAttribute(String telefone) {
        return telefone;
    }
}
