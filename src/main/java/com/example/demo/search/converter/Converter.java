package com.example.demo.search.converter;


import com.example.demo.document.AbstractDocument;
import com.example.demo.rest.dto.BaseDTO;

public interface Converter<E extends AbstractDocument, T extends BaseDTO> {

    Class<E> getDocumentClass();

    T convertToDto(E document);

    E convertToDocument(T dto);
}
