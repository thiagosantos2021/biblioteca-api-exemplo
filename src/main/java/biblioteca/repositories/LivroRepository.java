package biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	//@Query("SELECT obj FROM Livro obj WHERE obj.categoria_id = id_cat ORDER BY titulo")
	//List<Livro> findAllByCategoria(@Param(value="id_cat") Integer id_cat);
	
    List<Livro> findAllByCategoriaIdOrderByTitulo(Integer id_cat);
}
