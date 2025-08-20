package pe.edu.cibertec.waformulariosspring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waformulariosspring.model.LoginModel;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("mostrarAlerta", false);
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("loginModel") LoginModel loginModel, Model model){

        if(loginModel.getUsuario().equals("sebas") &&
                loginModel.getPassword().equals("123456")){
            model.addAttribute("mensaje", "Bienvenido: " + loginModel.getUsuario());
            return "home";
        }
        model.addAttribute("mostrarAlerta", true);
        model.addAttribute("mensaje", "Usuario y/o contraseña incorrecto");
        return "login";
    }

}
