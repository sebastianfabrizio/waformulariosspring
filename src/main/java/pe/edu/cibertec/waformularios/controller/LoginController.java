package pe.edu.cibertec.waformularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waformularios.model.LoginModel;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("loginModel") LoginModel loginModel, Model model){

        if(loginModel.getUsuario().equals("sebastian") &&
                loginModel.getPassword().equals("123")) {
            return "home";
        }
        return "login";
    }

}
