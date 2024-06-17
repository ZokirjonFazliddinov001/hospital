package uz.pdp.hospitalexam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.hospitalexam.entity.Patient;
import uz.pdp.hospitalexam.service.PatientService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final PatientService patientService;








}
