package br.com.controlunion.stock.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "alarm_document")
@PrimaryKeyJoinColumn(name = "id")
public class AlarmDocument extends Alarm {

    @ManyToOne
    @JoinColumn(name = "employee_document_id")
    private EmployeeDocument document;

    public EmployeeDocument getDocument() {
        return document;
    }

    public void setDocument(EmployeeDocument document) {
        this.document = document;
    }

}
