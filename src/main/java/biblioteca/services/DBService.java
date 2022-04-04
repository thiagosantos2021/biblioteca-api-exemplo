package biblioteca.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.domain.Categoria;
import biblioteca.domain.Livro;
import biblioteca.repositories.CategoriaRepository;
import biblioteca.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "lorem ipsum...", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Ian Sommerville", "lorem ipsum...", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "lorem ipsum...", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "lorem ipsum...", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "lorem ipsum...", cat2);
		
		cat1.getLivro().addAll(Arrays.asList(l1, l2));
		cat2.getLivro().addAll(Arrays.asList(l3,l4,l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
