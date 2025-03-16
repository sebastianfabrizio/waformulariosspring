package pe.edu.cibertec.waformularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.waformularios.model.LoginModel;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
}
