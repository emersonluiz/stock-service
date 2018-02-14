package br.com.controlunion.stock.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.dto.StockDto;
import br.com.controlunion.stock.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockResource {

    @Inject
    StockService stockService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/product/{productId}", method = RequestMethod.GET, produces = { "application/json" })
    public List<StockDto> findOne(@PathVariable("productId") int productId) throws Exception {
        return stockService.findByProduct(productId);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
    public List<StockDto> findAll(Pageable pageable) throws Exception {
        return stockService.findAll();
    }
}
