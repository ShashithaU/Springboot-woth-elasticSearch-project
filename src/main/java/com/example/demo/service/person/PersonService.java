package com.example.demo.service.person;


import com.example.demo.document.person.PersonDocument;
import com.example.demo.document.person.PersonRepository;
import com.example.demo.rest.person.dto.PersonDTO;
import com.example.demo.search.ElasticsearchProxy;
import com.example.demo.search.SearchFilters;
import com.example.demo.search.query.QueryType;
import com.example.demo.search.query.SearchMeta;
import com.example.demo.service.person.converter.PersonDTOConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonDTOConverter converter;
    private final ElasticsearchProxy<PersonDocument, PersonDTO> client;

    public PersonService(final PersonRepository repository,
                         final PersonDTOConverter converter,
                         ElasticsearchProxy<PersonDocument, PersonDTO> client) {
        this.repository = repository;
        this.converter = converter;
        this.client = client;
    }

    public void save(final PersonDTO dto) {
        final PersonDocument document = converter.convertToDocument(dto);
        if (document == null) {
            return;
        }

        repository.save(document);
    }

    public List<PersonDTO> search(SearchFilters filters) {
        return client.search(
                filters,
                new SearchMeta(List.of("name"), "person", QueryType.MATCH),
                PersonDocument.class
        );
    }
}
