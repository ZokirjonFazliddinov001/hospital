package uz.pdp.hospitalexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.hospitalexam.entity.Patient;
import uz.pdp.hospitalexam.service.PatientService;

@Controller
@RequestMapping("/api/patient")
public class PatientController {
    private PatientService patientService;


    @GetMapping("/search/{phone}")
    public String searchPatient(@PathVariable String phone, Model model) {
        Patient patient = patientService.findByPhone(phone);
        model.addAttribute("patient", patient);
        return "admin/admin";
    }
}
