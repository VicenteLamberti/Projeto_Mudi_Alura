package br.com.alura.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("procurandoPorStatusCache")
	public List<Pedido>findByStatus(StatusPedido status, Pageable pageable);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username= :username")
	public List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username=:username AND p.status = :status")
	public List<Pedido> findByStatusEuUsuario(@Param("username")String username, @Param("status") StatusPedido status);
}
