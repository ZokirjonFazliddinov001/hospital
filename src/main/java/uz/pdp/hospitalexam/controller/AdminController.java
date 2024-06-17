package uz.pdp.hospitalexam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hospitalexam.entity.Admission;
import uz.pdp.hospitalexam.entity.Doctor;
import uz.pdp.hospitalexam.entity.Patient;
import uz.pdp.hospitalexam.entity.enums.Status;
import uz.pdp.hospitalexam.service.AdmissionService;
import uz.pdp.hospitalexam.service.DoctorService;
import uz.pdp.hospitalexam.service.PatientService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AdmissionService admissionService;

    @GetMapping
    public String index(Model model) {
        List<Patient> patients = patientService.findAll();
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors", doctors);
        return "admin/admin";
    }

//    @GetMapping("/info/{id}")
//    public String info(@PathVariable int id, Model model) {
//        List<Patient> patients = patientService.findAll();
//        List<Doctor> doctors = doctorService.findAll();
//
//        model.addAttribute("patients", patients);
//        model.addAttribute("doctors", doctors);
//        Optional<Patient> optionalPatient = patientService.findById(id);
//        if (optionalPatient.isPresent()) {
//            Patient patient = optionalPatient.get();
//            List<Admission> admissions = admissionService.findByPatientId(patient.getId());
//            model.addAttribute("currentPatient", patient);
//            model.addAttribute("admissions", admissions);
//
//        }
//        return "admin/admin";
//    }

    @GetMapping("/patient/search")
    public String searchPatient(@RequestParam String phone, Model model) {
        Patient patient = patientService.findByPhone(phone);
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("currentPatient", patient);
        model.addAttribute("doctors", doctors);
        return "admin/admin";
    }

    @PostMapping("/createAdmission")
    public String updatePatient(
            @RequestParam int patientId,
            @RequestParam int selectedOption,
            @RequestParam String dateTime,
            @RequestParam String description
    ) {
        Optional<Patient> optionalPatient = patientService.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            Doctor doctor = doctorService.findById(selectedOption).orElse(null);
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            if (localDateTime.isBefore(LocalDateTime.now())) {
                Admission admission = Admission.builder()
                        .patient(patient)
                        .doctor(doctor)
                        .localDateTime(LocalDateTime.parse(dateTime))
                        .description(description)
                        .status(Status.LATE)
                        .build();
                admissionService.save(admission);
            }else {
                Admission admission = Admission.builder()
                        .patient(patient)
                        .doctor(doctor)
                        .localDateTime(LocalDateTime.parse(dateTime))
                        .description(description)
                        .status(Status.ENTER)
                        .build();
                admissionService.save(admission);
            }
        }
        return "redirect:/api/admin/info/" + patientId;
    }


//    @PostMapping("/update/{id}")
//    public String updateAdmission(@PathVariable int id, Model model) {
//        // Fetch the admission by ID
//        Admission admission = admissionService.findById(id);
//        if (admission != null) {
//            admission.setStatus(Status.WAITING);
//            // Update the admission status or perform other update logic
//            admissionService.updateAdmission(admission);
//            model.addAttribute("message", "Admission updated successfully");
//        } else {
//            model.addAttribute("error", "Admission not found");
//        }
//        // Redirect to the admin page or another appropriate page
//        return "redirect:/api/admin";
//    }



//    @PostMapping("/update/{id}")
//    public String updateAdmission(@PathVariable int id, Model model) {
//        // Fetch the admission by ID
//        Admission admission = admissionService.findById(id);
//        if (admission != null) {
//            admission.setStatus(Status.WAITING);
//            // Update the admission status or perform other update logic
//            admissionService.updateAdmission(admission);
//            model.addAttribute("message", "Admission updated successfully");
//        } else {
//            model.addAttribute("error", "Admission not found");
//        }
//        // Redirect to the admin page or another appropriate page
//        return "redirect:/api/admin";
//    }
//
//    @GetMapping("/info/{id}")
//    public String info(@PathVariable int id, Model model) {
//        List<Patient> patients = patientService.findAll();
//        List<Doctor> doctors = doctorService.findAll();
//
//        model.addAttribute("patients", patients);
//        model.addAttribute("doctors", doctors);
//        Optional<Patient> optionalPatient = patientService.findById(id);
//        if (optionalPatient.isPresent()) {
//            Patient patient = optionalPatient.get();
//            List<Admission> admissions = admissionService.findByPatientId(patient.getId());
//            model.addAttribute("currentPatient", patient);
//            model.addAttribute("admissions", admissions);
//        } else {
//            model.addAttribute("error", "Patient not found");
//        }
//        return "admin/admin";
//    }


    @PostMapping("/update/{id}")
    public String updateAdmission(@PathVariable int id, Model model) {
        // Fetch the admission by ID
        Admission admission = admissionService.findById(id);
        if (admission != null) {
            admission.setStatus(Status.WAITING);
            // Update the admission status or perform other update logic
            admissionService.updateAdmission(admission);
            model.addAttribute("message", "Admission updated successfully");
        } else {
            model.addAttribute("error", "Admission not found");
        }
        // Redirect to the admin page or another appropriate page
        return "redirect:/api/admin";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
        List<Patient> patients = patientService.findAll();
        List<Doctor> doctors = doctorService.findAll();

        model.addAttribute("patients", patients);
        model.addAttribute("doctors", doctors);
        Optional<Patient> optionalPatient = patientService.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            List<Admission> admissions = admissionService.findByPatientId(patient.getId());
            model.addAttribute("currentPatient", patient);
            model.addAttribute("admissions", admissions);
        } else {
            model.addAttribute("error", "Patient not found");
        }
        return "admin/admin";
    }
}
