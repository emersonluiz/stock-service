package br.com.controlunion.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlunion.stock.model.AlarmDocument;

public interface AlarmDocumentRepository extends JpaRepository<AlarmDocument, Integer> {

}
