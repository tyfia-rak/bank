package com.bank.prog4.Controller;

import com.bank.prog4.entity.Retreat;
import com.bank.prog4.service.RetreatService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RetreatController {
    private RetreatService retreatService;

    public RetreatController(RetreatService retreatService){
        this.retreatService = retreatService;
    }
    @GetMapping("/all_retreat")
    public List<Retreat> AllRetreat() throws SQLException{
        return retreatService.findAll();
    }
}
