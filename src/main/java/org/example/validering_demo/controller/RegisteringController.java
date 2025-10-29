package org.example.validering_demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.validering_demo.model.Bruker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisteringController {

    private final List<Bruker> brukere = new ArrayList<>();

    @GetMapping("/")
    public String root() {
        return "redirect:/registrering";
    }

    @GetMapping("/registrering")
    public String visSkjema(Model model) {
        model.addAttribute("bruker", new Bruker());
        return "registrering";
    }

    @PostMapping("/registrering")
    public String registrerBruker(@Valid @ModelAttribute Bruker bruker, BindingResult errors, RedirectAttributes ra) {

        if (!bruker.getPassord().equals(bruker.getPassord2())) {
            errors.rejectValue("passord2", "mismatch", "Passordene må være like");
        }

        if (errors.hasErrors()) {
            return "registrering";
        }
        brukere.add(bruker);

        ra.addFlashAttribute("melding", "Takk for registeringen" + bruker.getFornavn());
        return "redirect:/registrert";
    }

    @GetMapping("/registrert")
    public String registrert() {
        return "registrert";              // -> /WEB-INF/registrert.jsp
    }

    @GetMapping("/brukere")
    public String visAlle(HttpSession session, Model model) {
        Object innlogget = session.getAttribute("innloggetBruker");
        if  (innlogget == null) {
            return "redirect:/login";
        }
        model.addAttribute("brukere", brukere);
        return "brukeroversikt";
    }

    public List<Bruker> hentBrukere() {
        return brukere;
    }
}
