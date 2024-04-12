package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinaController {

	private List<Disciplina> disciplinas;

	public DisciplinaController() {
		this.disciplinas = new ArrayList<>();
		disciplinas.add(new Disciplina(1, "Programação de Sistemas", "PS1", "BSI", 1));
		disciplinas.add(new Disciplina(2, "Estrutura de Dados" , "ED1", "BSI", 2));
		disciplinas.add(new Disciplina(3, "Comunicação de dados", "CD1", "BSI", 2));
	}

	@GetMapping("/api/disciplinas")
	Iterable<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}
	
	@GetMapping("/api/disciplinas/{id}")
	Optional<Disciplina> getDisciplina(@PathVariable long id) {
		for (Disciplina d: disciplinas) {
			if (d.getId() == id) {
				return Optional.of(d);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/disciplinas")
	Disciplina createDisciplina(@RequestBody Disciplina d) {
		long maxId = 1;
		for (Disciplina disc: disciplinas) {
			if (disc.getId() > maxId) {
				maxId = disc.getId();
			}
		}
		d.setId(maxId+1);
		disciplinas.add(d);
		return d;
	}
	
	@PutMapping("/api/disciplinas/{disciplinaId}")
	Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
		Optional<Disciplina> opt = this.getDisciplina(disciplinaId);
		if (opt.isPresent()) {
			Disciplina disciplina = opt.get();
			disciplina.setNome(disciplinaRequest.getNome());
			disciplina.setSigla(disciplinaRequest.getSigla());
			disciplina.setCurso(disciplinaRequest.getCurso());
            disciplina.setSemestre(disciplinaRequest.getSemestre());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/disciplinas/{id}")
	void deleteProfessor(@PathVariable long id) {
		disciplinas.removeIf(d -> d.getId() == id);
	}		
}



