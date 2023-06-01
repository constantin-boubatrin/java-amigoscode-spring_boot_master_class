package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    /** Instead of this use '@Slf4j' and 'log' instance */
//    private final static Logger LOGGER =
//            LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    /** Instead of this use '@AllArgsConstructor' */
//    @Autowired
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    /** Instead of 'LOGGER' use 'log' instance */
    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException =
                                    new NotFoundException("customer with id " + id + " not found");
                            log.error("Error in getCustomer method {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
