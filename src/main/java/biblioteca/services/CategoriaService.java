package biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.domain.Categoria;
import biblioteca.dtos.CategoriaDTO;
import biblioteca.repositories.CategoriaRepository;
import biblioteca.services.exceptions.DataIntegrityViolationException;
import biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado:" + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);	
		}catch(DataIntegrityViolationException e) {
			throw new biblioteca.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada, pois possui livros associados!!!");
		}
	}
}
