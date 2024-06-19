package exam.tourdk;

import exam.tourdk.entity.Rider;
import exam.tourdk.entity.Team;
import exam.tourdk.repository.RiderRepository;
import exam.tourdk.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TourdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourdkApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(TeamRepository teamRepository, RiderRepository riderRepository) {
        return args -> {
            Team team1 = new Team();
            team1.setName("Team 1");
            Team team2 = new Team();
            team2.setName("Team 2");

            teamRepository.save(team1);
            teamRepository.save(team2);

            Rider rider1 = new Rider();
            rider1.setName("Rider 1");
            rider1.setTeam(team1);
            rider1.setBirthDate(LocalDate.parse("2000-01-01"));
            rider1.setSprintPoints(10);
            rider1.setMountainPoints(20);
            rider1.setTotalTime(7200);
            riderRepository.save(rider1);

            Rider rider2 = new Rider();
            rider2.setName("Rider 2");
            rider2.setTeam(team1);
            rider2.setBirthDate(LocalDate.parse("2000-01-02"));
            rider2.setSprintPoints(20);
            rider2.setMountainPoints(10);
            rider2.setTotalTime(7000);
            riderRepository.save(rider2);

            Rider rider3 = new Rider();
            rider3.setName("Rider 3");
            rider3.setTeam(team2);
            rider3.setBirthDate(LocalDate.parse("2000-01-03"));
            rider3.setSprintPoints(30);
            rider3.setMountainPoints(30);
            rider3.setTotalTime(7100);
            riderRepository.save(rider3);
        };
    }

}
