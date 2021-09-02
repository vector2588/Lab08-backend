package se331.lab.rest.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitAppOrganizer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .id(987L)
                .name("Peter Parker")
                .address("There!!")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(879L)
                .name("John Doe")
                .address("Behind you")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(435L)
                .name("God")
                .address("Everywhere")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(553L)
                .name("Tony Stark")
                .address("Stark cooperation")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(375L)
                .name("Steve Roger")
                .address("American army")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(473L)
                .name("Techara")
                .address("Wakanda")
                .build());
    }
}
