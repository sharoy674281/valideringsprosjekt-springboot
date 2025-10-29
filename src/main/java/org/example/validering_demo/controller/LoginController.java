package org.example.validering_demo.controller;

import jakarta.servlet.http.HttpSession;
import org.apache.juli.logging.Log;
import org.example.validering_demo.model.Bruker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    private final List<Bruker> brukere;

    public LoginController(RegisteringController registeringController) {
        this.brukere = registeringController.hentBrukere();
    }

    @GetMapping("/login")
    public String visLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String epost, @RequestParam String passord, Model model, HttpSession session) {
        for  (Bruker bruker : brukere) {
            if (bruker.getEpost().equals(epost) && bruker.getPassord().equals(passord)) {
                session.setAttribute("innloggetBruker", bruker);
                return "redirect:/minside";
            }
        }
        model.addAttribute("feil", "Feil epost eller passord");
        return "login";
    }

    @GetMapping("/minside")
    public String minSide(HttpSession session, Model model) {
        Bruker  bruker = (Bruker) session.getAttribute("innloggetBruker");
        if (bruker == null) {
            return "redirect:/login";
        }
        model.addAttribute("bruker", bruker);
        return "minside";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
