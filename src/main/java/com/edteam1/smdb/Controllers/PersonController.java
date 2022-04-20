package com.edteam1.smdb.Controllers;

import com.edteam1.smdb.domain.Occupation;
import com.edteam1.smdb.domain.Person;
import com.edteam1.smdb.service.BaseService;
import com.edteam1.smdb.service.PersonService;
import com.edteam1.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController extends AbstractController<Person>{

    private final PersonService personService;

    @GetMapping(value = "/all")
    public ResponseEntity<ApiResponse<List<Person>>> findALL() {
        return ResponseEntity.ok(
                ApiResponse.<List<Person>>builder().data(personService.findAll()).build());
    }
    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<ApiResponse<Person>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(
                ApiResponse.<Person>builder().data(personService.findByName(name)).build());
    }

    @GetMapping(params = {"occupation"})
    public ResponseEntity<ApiResponse<List<Person>>> findByOccupation(@RequestParam String occupation) {
        if (Occupation.ACTOR.getName().equals(occupation)) {
            return ResponseEntity.ok(
                    ApiResponse.<List<Person>>builder().data(personService.findByOccupation(Occupation.ACTOR)).build());
        } else if(Occupation.DIRECTOR.getName().equals(occupation)) {
            return ResponseEntity.ok(
                    ApiResponse.<List<Person>>builder().data(personService.findByOccupation(Occupation.DIRECTOR)).build());
        } else {
            return ResponseEntity.ok(
                    ApiResponse.<List<Person>>builder().data(personService.findByOccupation(Occupation.PRODUCER)).build());
        }
    }
}
