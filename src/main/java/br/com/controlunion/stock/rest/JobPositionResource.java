package br.com.controlunion.stock.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.model.JobPosition;
import br.com.controlunion.stock.service.JobPositionService;

@RestController
@RequestMapping("/jobPositions")
public class JobPositionResource {

	@Inject
	JobPositionService jobPositionService;

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<JobPosition> findAll() {
		return jobPositionService.findAll();
	}
	
}
