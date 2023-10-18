package com.Mapping.ManyToOne;

import com.Mapping.ManyToOne.entity.Account;
import com.Mapping.ManyToOne.entity.Branch;
import com.Mapping.ManyToOne.repository.AccountRepository;
import com.Mapping.ManyToOne.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
public class ManyToOneApplication {
	@Autowired
    private  AccountRepository accountRepository;
	@Autowired
	private  BranchRepository branchRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class, args);
    }

	@PostMapping("branch")
	public Branch addBranch(@RequestBody final Branch branch){
		return branchRepository.save(branch);
	}

    @PostMapping("add/account/{branchId}")
    public Account addAccount(@RequestBody Account account, @PathVariable int branchId) {
		var branch=branchRepository.findById(branchId)
				.orElseThrow();
		account.setBranch(branch);
        return accountRepository.save(account);
    }

    @GetMapping("fetch/account")
    public List<Account> fetchAccount() {
        return accountRepository.findAll();
    }
}
