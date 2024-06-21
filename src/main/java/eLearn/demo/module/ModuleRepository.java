package eLearn.demo.module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ModuleRepository extends JpaRepository<Module,Long> {
}
