package pl.max.bookapp.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.max.bookapp.grade.GradeManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeApi {

    private GradeManager grades;

    @Autowired
    public GradeApi(GradeManager grades) {
        this.grades = grades;
    }

    @GetMapping("/all")
    public Iterable<Grade> getAll() {
        return grades.findALL();
    }
    @GetMapping
    public Optional<Grade> getById(@RequestParam Long index) {

        return grades.findById(index);
    }
    @PostMapping
    public Grade addGrade(@RequestBody Grade grade) {
        return grades.save(grade);
    }

    @PutMapping
    public Grade updateGrade(@RequestBody Grade grade) {
        return grades.save(grade);
    }
    @DeleteMapping
    public void deleteGrade(@RequestParam Long index) {
        grades.deleteById(index);
    }
}
