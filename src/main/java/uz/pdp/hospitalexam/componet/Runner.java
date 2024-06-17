package uz.pdp.hospitalexam.componet;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.hospitalexam.entity.*;
import uz.pdp.hospitalexam.entity.enums.RoleType;
import uz.pdp.hospitalexam.repo.*;
import uz.pdp.hospitalexam.service.RoomService;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final PatientRepository patientRepository;
    private final UserRepo userRepo;
    private final RoomRepository roomRepository;
    private final DoctorRepository doctorRepository;
    private final ExpertiseRepository expertiseRepository;


    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) throws Exception {

        if (ddl.equals("create")) {

            Role admin = Role.builder().role(RoleType.ROLE_ADMIN).build();
            Role patientRole = Role.builder().role(RoleType.ROLE_PATIENT).build();
            Role doctorRole = Role.builder().role(RoleType.ROLE_DOCTOR).build();
            Role super_user = Role.builder().role(RoleType.ROLE_SUPER_USER).build();

            roleRepository.save(admin);
            roleRepository.save(patientRole);
            roleRepository.save(doctorRole);
            roleRepository.save(super_user);

            User user1 = User.builder()
                    .firstName("Sardor")
                    .lastName("Sardorov")
                    .phone("936524717")
                    .password("123")
                    .role(patientRole)
                    .build();

            User user2 = User.builder()
                    .firstName("Nozim")
                    .lastName("Nozimov")
                    .phone("936521881")
                    .password("123")
                    .role(patientRole)
                    .build();

            userRepo.save(user1);
            userRepo.save(user2);
            User user3 = User.builder()
                    .firstName("Billgets")
                    .lastName("Sardorov")
                    .phone("936520000")
                    .password("123")
                    .role(doctorRole)
                    .build();

            User user4 = User.builder()
                    .firstName("Sharzod")
                    .lastName("Sultonov")
                    .phone("936527777")
                    .password("123")
                    .role(doctorRole)
                    .build();
            User user5 = User.builder()
                    .firstName("Dilmurod")
                    .lastName("Elbekov")
                    .phone("936528888")
                    .password("123")
                    .role(doctorRole)
                    .build();

            userRepo.save(user3);
            userRepo.save(user4);
            userRepo.save(user5);



            Room room1 = Room.builder()
                    .roomName("101-xona")
                    .build();

            Room room2 = Room.builder()
                    .roomName("102-xona")
                    .build();

            Room room3 = Room.builder()
                    .roomName("103-xona")
                    .build();


            roomRepository.save(room1);
            roomRepository.save(room2);
            roomRepository.save(room3);


            Expertise expertise1 = Expertise.builder()
                    .expertiseName("Kardiolog")
                    .build();


            Expertise expertise2 = Expertise.builder()
                    .expertiseName("Teropev")
                    .build();


            Expertise expertise3 = Expertise.builder()
                    .expertiseName("Nevrotolog")
                    .build();


            expertiseRepository.save(expertise1);
            expertiseRepository.save(expertise2);
            expertiseRepository.save(expertise3);



            Doctor doctor1 = Doctor.builder()
                    .expertise(expertise1)
                    .room(room1)
                    .user(user3)
                    .build();

            Doctor doctor2 = Doctor.builder()
                    .expertise(expertise2)
                    .room(room2)
                    .user(user4)
                    .build();

            Doctor doctor3 = Doctor.builder()
                    .expertise(expertise3)
                    .room(room3)
                    .user(user5)
                    .build();




            doctorRepository.save(doctor1);
            doctorRepository.save(doctor2);
            doctorRepository.save(doctor3);




            Patient patient1 = Patient.builder()
                    .user(user1)
                    .build();

            Patient patient2 = Patient.builder()
                    .user(user2)
                    .build();


            patientRepository.save(patient1);
            patientRepository.save(patient2);




        }

    }
}
