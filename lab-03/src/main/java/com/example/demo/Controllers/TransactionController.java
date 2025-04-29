package com.example.demo.Controllers;

import com.example.demo.Entities.Transaction;
import com.example.demo.Entities.User;
import com.example.demo.services.TransactionService;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private  UserService userService;

    public TransactionController(TransactionService transactionService , UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.findAll();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.delete(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        Transaction existing = transactionService.findById(id);

        existing.setAmount(updatedTransaction.getAmount());
        existing.setDate(updatedTransaction.getDate());
        existing.setStatus(updatedTransaction.getStatus());
        existing.setSender(updatedTransaction.getSender());
        existing.setReceiver(updatedTransaction.getReceiver());

        return transactionService.save(existing);
    }


    @PostMapping("/send")
    public Transaction sendMoney(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam Double amount) {

        User sender = userService.findById(senderId);
        User receiver = userService.findById(receiverId);

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(amount);
        transaction.setStatus("PENDING");
        transaction.setDate(java.time.LocalDateTime.now());

        return transactionService.save(transaction);
    }




}
