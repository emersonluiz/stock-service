package br.com.controlunion.stock.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.controlunion.stock.model.Document;
import br.com.controlunion.stock.repository.DocumentRepository;

@Named
public class DefaultDocumentService implements DocumentService {

    @Inject
    DocumentRepository documentRepository;

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

}
