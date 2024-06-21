package eLearn.demo.module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    private ModuleRepository moduleRepository;
    @Autowired
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }
    public List<Module> getAllModules(){
        return moduleRepository.findAll();
    }
}
