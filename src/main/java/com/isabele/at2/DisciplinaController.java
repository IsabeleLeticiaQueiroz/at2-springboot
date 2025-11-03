package com.isabele.at2;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private Map<Integer, Disciplina> disciplinas = new HashMap<>();

    public DisciplinaController() {
        disciplinas.put(1, new Disciplina(1, "Desenvolvimento Web"));
        disciplinas.put(2, new Disciplina(2, "Banco de Dados"));
    }

    @GetMapping
    public Collection<Disciplina> listar() {
        return disciplinas.values();
    }

    @GetMapping("/{id}")
    public Disciplina buscar(@PathVariable int id) {
        return disciplinas.get(id);
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina d) {
        int id = disciplinas.size() + 1;
        d.setId(id);
        disciplinas.put(id, d);
        return d;
    }
}
