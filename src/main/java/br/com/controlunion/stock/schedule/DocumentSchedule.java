package br.com.controlunion.stock.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.controlunion.stock.model.AlarmDocument;
import br.com.controlunion.stock.model.Employee;
import br.com.controlunion.stock.model.EmployeeDocument;
import br.com.controlunion.stock.repository.AlarmDocumentRepository;
import br.com.controlunion.stock.repository.EmployeeRepository;

@Service
public class DocumentSchedule {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentSchedule.class);

    @Inject
    EmployeeRepository employeeRepository;
    @Inject
    AlarmDocumentRepository alarmRepository;

    @Scheduled(fixedRate=5000)
    public void checkProducts() {
        LOG.debug("DocumentSchedule is running!!!");

        //Date d = new Date();

        //Calendar c = Calendar.getInstance();
        //c.setTime(d);
        //c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 30);
        
        //c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
        //c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);

        //List<Employee> employee = employeeRepository.findValidity(c.getTime());
        List<Employee> employee2 = employeeRepository.findValidity();

        /*if(employee != null) {
            if(employee.size() > 0) {
                for (Employee e : employee) {
                    for (EmployeeDocument ed : e.getDocuments()) {
                        if(ed.getIssueDate() != null && ed.getValidity() != null) {
                            AlarmDocument alarmDocument = new AlarmDocument();
                            alarmDocument.setDescription("O " + ed.getDocument().getName() + " do funcionário " + e.getName() + " tem menos de um mês para o vencimento!");
                            alarmDocument.setDocument(ed);
                            alarmRepository.save(alarmDocument);

                            LOG.debug("### DocumentSchedule was found!!! ###");
                        }
                    }
                }
            }
        }*/

        if(employee2 != null) {
            if(employee2.size() > 0) {

                for (Employee e : employee2) {
                    for (EmployeeDocument ed : e.getDocuments()) {
                        if(ed.getExpirationDate() != null) {
                            Date d = ed.getExpirationDate();
                            Calendar c = Calendar.getInstance();
                            c.setTime(d);
                            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 30);

                            Date today = new Date();
                            Calendar cToday = Calendar.getInstance();
                            cToday.setTime(today);

                            if(c.getTimeInMillis() > cToday.getTimeInMillis()) {
                                AlarmDocument alarmDocument = new AlarmDocument();
                                alarmDocument.setDescription("O " + ed.getDocument().getName() + " do funcionário " + e.getName() + " tem menos de um mês para o vencimento!");
                                alarmDocument.setDocument(ed);
                                alarmRepository.save(alarmDocument);

                                LOG.debug("### DocumentSchedule was found!!! ###");
                            }
                        }

                        if(ed.getIssueDate() != null && ed.getValidity() != null) {
                            Date d1 = ed.getIssueDate();
                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(d1);
                            c1.add(Calendar.MONTH, ed.getValidity());
    
                            Date d2 = new Date();
                            Calendar c2 = Calendar.getInstance();
                            c2.setTime(d2);
                            c2.set(Calendar.DAY_OF_MONTH, c2.get(Calendar.DAY_OF_MONTH) - 30);

                            if(c1.getTimeInMillis() > c2.getTimeInMillis()) {
                                AlarmDocument alarmDocument = new AlarmDocument();
                                alarmDocument.setDescription("O " + ed.getDocument().getName() + " do funcionário " + e.getName() + " tem menos de um mês para o vencimento!");
                                alarmDocument.setDocument(ed);
                                alarmRepository.save(alarmDocument);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                                LOG.debug(sdf.format(c1.getTime()) + " ::: @@@ DocumentSchedule was found!!! @@@ ::: " + sdf2.format(c2.getTime()));
                                break;
                            }
                        }
                    }
                    
                }
            }
        }
    }
}
