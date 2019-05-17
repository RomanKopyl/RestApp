package newProject.controllers.viewControllers;

import newProject.domain.Transaction;
import newProject.domain.User;
import newProject.domain.TransactionState;
import newProject.repos.TransactionRepo;
import newProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Transaction> transactions = transactionRepo.findAll();
        model.put("transactions", transactions);
        return "main";
    }

//    @GetMapping("/main")
//    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
//        Iterable<Transaction> transactions = transactionRepo.findAll();
//
//        if (filter != null && !filter.isEmpty()) {
//            transactions = transactionRepo.findByAuthor(filter);
//        } else {
//            transactions = transactionRepo.findAll();
//        }
//
//        model.addAttribute("transactions", transactions);
//        model.addAttribute("filter", filter);
//
//        return "main";
//    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam TransactionState state,
            @RequestParam BigDecimal amount, Map<String, Object> model
    ){
        if (state != null && amount != null) {
            Date date = new Date();
            Transaction transaction = new Transaction(date, amount, state, user);
            transactionRepo.save(transaction);
        }

        Iterable<Transaction> transactions = transactionRepo.findAll();
        model.put("transactions", transactions);

        return "main";
    }
}