package exam.tourdk.repository;

import exam.tourdk.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Integer> {
    List<Rider> findByTeamId(int teamId);
}
