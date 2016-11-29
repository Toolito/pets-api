package com.example.pets;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Resource
    private PetRepository repo;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Pet> listTodos() {
        List<Pet> pets = new ArrayList<>();
        repo.findAll().forEach(pets::add);

        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pet get(@PathVariable String id) {
        return repo.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Pet create(@RequestBody Pet pet) {
        repo.save(pet);

        return pet;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

}
