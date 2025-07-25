package com.example.demo.service.person.converter;


import com.example.demo.document.person.PersonDocument;
import com.example.demo.rest.person.dto.PersonDTO;
import com.example.demo.search.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDTOConverter implements Converter<PersonDocument, PersonDTO> {

    @Override
    public Class<PersonDocument> getDocumentClass() {
        return PersonDocument.class;
    }

    @Override
    public PersonDTO convertToDto(final PersonDocument document) {
        if(document == null) {
            return null;
        }

        PersonDTO dto = new PersonDTO();
        dto.setId(document.getId());
        dto.setName(document.getName());

        return dto;
    }

    @Override
    public PersonDocument convertToDocument(final PersonDTO dto) {
        if (dto == null) {
            return null;
        }

        final PersonDocument personDocument = new PersonDocument();
        personDocument.setId(dto.getId());
        personDocument.setName(dto.getName());

        return personDocument;
    }
}
