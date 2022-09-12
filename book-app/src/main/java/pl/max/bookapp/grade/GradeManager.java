package pl.max.bookapp.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.max.bookapp.grade.Grade;
import pl.max.bookapp.grade.GradeRepo;


import java.util.Optional;

@Service
public class GradeManager {

    private GradeRepo gradeRepo;

    @Autowired
    public GradeManager(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public Optional<Grade> findById(Long id) {
        return gradeRepo.findById(id);
    }

    public Iterable<Grade> findALL() {
        return gradeRepo.findAll();
    }

    public Grade save(Grade grade) {
        return gradeRepo.save(grade);
    }

    public void deleteById(Long id) {
        gradeRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Grade(1L,9L));
        save(new Grade(2L,6L));

    }
}
