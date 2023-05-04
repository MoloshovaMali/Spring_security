package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping()
    public String getEmployee(){
        return "for_employees";
    }
    @GetMapping("/info_hr")
    public String getHr(){
        return "for_hr";
    }
    @GetMapping("/info_manager")
    public String getManager(){
        return "for_manager";
    }
}
