package eLearn.demo.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "eLearning/modules")
public class ModuleController {
    private ModuleService moduleService;
    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    @GetMapping("/all")
    public List<Module> getAllModules(){
        return moduleService.getAllModules();
    }
}