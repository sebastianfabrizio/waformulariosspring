package pe.edu.cibertec.waformulariosspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.waformulariosspring.model.ImcModel;

@Controller
public class ImcController {

    @GetMapping("/imc")
    public String InicioImc(Model model){
        model.addAttribute("imcModel", new ImcModel());
        model.addAttribute("mostrarAlerta", false);
        return "imc";
    }

    @PostMapping("/imc")
    public String calcularImc(@ModelAttribute("imcModel") ImcModel imcModel, Model model){
        double tallam = imcModel.getTalla() / 100;
        double valorImc = imcModel.getPeso() / (tallam * tallam);
        String diagnostico = "";

        if(valorImc<=18.5){
            diagnostico = "Por de bajo del peso";
        }
        else if(valorImc<=25){
            diagnostico = "Con peso normal";
        }
        else if(valorImc<=30){
            diagnostico = "Con sobrepeso";
        }
        else if(valorImc<=35){
            diagnostico = "Con obesidad leve";
        }
        else if(valorImc<=39){
            diagnostico = "Con obesidad media";
        }
        else{
            diagnostico="Con obesidad mórbida";
        }
        model.addAttribute("mostrarAlerta", true);
        model.addAttribute("resultado", "Su valor imc es: "
                + String.format("%.2f", valorImc)+", usted se encuentra: " + diagnostico);
        return "imc";
    }
}
