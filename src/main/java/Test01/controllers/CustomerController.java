package Test01.controllers;

import Test01.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Kevin", "kp", "1234"),
            new Customer(2, "Ana", "am", "1234"),
            new Customer(3, "Juan", "jp", "1234"),
            new Customer(4, "Pedro", "pp", "1234")
    ));

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
    }

//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @GetMapping("/{name}")
    public ResponseEntity<?> getCustomer(@PathVariable String name){
        for(Customer customer: customers){
            if (customer.getName().equalsIgnoreCase(name)){
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCustormer(@RequestBody Customer customer){
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully created");
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer){
        for (Customer c: customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return ResponseEntity.ok("Customer successfully updated: " + c.getName());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found" + customer.getName());
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        for (Customer c: customers){
            if (c.getId() == id ){
                customers.remove(c);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer successfully deleted: "+ id);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found: "+ id);
    }

//    @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer){
        for (Customer c: customers){
            if (c.getId() == customer.getId()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Customer succesfully updated: "+customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
    }
}
