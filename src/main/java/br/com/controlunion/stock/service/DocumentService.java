package br.com.controlunion.stock.service;

import java.util.List;

import br.com.controlunion.stock.model.Document;

public interface DocumentService {

    List<Document> findAll();
}
