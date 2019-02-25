package controller;

import model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.customer.CustomerService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/customers/")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Customer> getAllCustomers() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
        var entity = service.create(customer);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("{id}")
                                .buildAndExpand(entity.getId().toString())
                                .toUri()
                )
                .body(entity);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(
            @PathVariable Long id, @Valid @RequestBody Customer customer
    ) {
        return service.update(id, customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.delete(id);
    }
}