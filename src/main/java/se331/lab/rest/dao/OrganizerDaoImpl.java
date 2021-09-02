package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(987L)
                .name("Peter Parker")
                .address("There!!")
                .build());
        organizerList.add(Organizer.builder()
                .id(879L)
                .name("John Doe")
                .address("Behind you")
                .build());
        organizerList.add(Organizer.builder()
                .id(435L)
                .name("God")
                .address("Everywhere")
                .build());
        organizerList.add(Organizer.builder()
                .id(553L)
                .name("Tony Stark")
                .address("Stark cooperation")
                .build());
        organizerList.add(Organizer.builder()
                .id(375L)
                .name("Steve Roger")
                .address("American army")
                .build());
        organizerList.add(Organizer.builder()
                .id(473L)
                .name("Techara")
                .address("Wakanda")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
