package Test01.controllers;

import Test01.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Kevin", "kp", "1234"),
            new Customer(2, "Ana", "am", "1234"),
            new Customer(3, "Juan", "jp", "1234"),
            new Customer(4, "Pedro", "pp", "1234")
    ));

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/customers/{name}")
    public Customer getCustomer(@PathVariable String name){
        for(Customer customer: customers){
            if (customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

    @PostMapping("/customers")
    public Customer postCustormer(@RequestBody Customer customer){
        customers.add(customer);
        return  customer;
    }

    @PutMapping("/customers")
    public Customer putCustomer(@RequestBody Customer customer){
        for (Customer c: customers){
            if (c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/customers/{id}")
    public Customer deleteCustomer(@PathVariable int id){
//        for(int i=0; i < customers.size(); i++){
//            if (customers.get(i).getId() == id){
//                customers.remove(i);
//            }
//        }
        for (Customer c: customers){
            if (c.getId() == id ){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping("/customers")
    public Customer patchCustomer(@RequestBody Customer customer){
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
                return c;
            }
        }
        return null;
    }
}
