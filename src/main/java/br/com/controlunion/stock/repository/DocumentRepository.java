package br.com.controlunion.stock.repository;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.Document;

@Named
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    List<Document> findByEnable(Boolean enable);
}
