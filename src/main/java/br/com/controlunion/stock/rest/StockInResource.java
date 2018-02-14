package br.com.controlunion.stock.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.controlunion.stock.model.StockIn;
import br.com.controlunion.stock.service.StockInService;

@RestController
@RequestMapping("/stock/in")
public class StockInResource extends ExceptionResource {

    @Inject
    StockInService stockInService;

    @RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<StockIn> create(@RequestBody @Valid StockIn stockIn) throws Exception {
        stockInService.create(stockIn);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stockIn.getId()).toUri();
        return ResponseEntity.created(location).body(stockIn);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{stockInId}", method = RequestMethod.GET, produces = { "application/json" })
    public StockIn findOne(@PathVariable("stockInId") int stockInId) throws Exception {
        return stockInService.findOne(stockInId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{stockInId}", method = RequestMethod.PUT)
    public void update(@PathVariable("stockInId") int stockInId, @RequestBody StockIn stockIn) throws Exception {
        stockInService.update(stockInId, stockIn);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{stockInId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("stockInId") int stockInId) throws Exception {
        stockInService.delete(stockInId);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
    public Page<StockIn> findAll(@RequestParam(required = false, value = "productId") Integer productId, 
                           @RequestParam(required = false, value = "productCategoryId") Integer productCategoryId,
                           Pageable pageable) throws Exception {
        return stockInService.findAll(productCategoryId, productId, pageable);
    }
}
