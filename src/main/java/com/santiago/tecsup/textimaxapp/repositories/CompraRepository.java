package com.santiago.tecsup.textimaxapp.repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.santiago.tecsup.textimaxapp.models.Compra;

@Repository
public class CompraRepository {

	private static final Logger logger = LoggerFactory.getLogger(CompraRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Compra> listar(){
		logger.info("call listar()");
		
		String sql = "select * from looccabecera_app where estado <>1";
		
		List<Compra> compras = jdbcTemplate.query(sql, new RowMapper<Compra>() {
			public Compra  mapRow(ResultSet rs, int rowNum) throws SQLException {
				Compra compra = new Compra();
				compra.setId(rs.getInt("id"));
				compra.setAnumordcom(rs.getString("anumordcom"));
				compra.setCliente(rs.getString("cliente"));
				compra.setFormapago(rs.getString("formapago"));
				compra.setMoneda(rs.getString("moneda"));
				compra.setTotal(rs.getDouble("total"));
				compra.setEstado(rs.getString("estado"));
				compra.setAfecordcom(rs.getString("afecordcom"));
				return compra;
			}
		});

		logger.info("compras: " + compras);
		
		return compras;
	}
	
	public void eliminar(Integer id) {
		logger.info("eliminar " + id);
		String sql = "delete from looccabecera_app where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	public Compra obtener(Integer id){
		logger.info("obtener " + id);
		
		String sql = "select * from looccabecera_app where id = ?";
		
		Compra compra = jdbcTemplate.queryForObject(sql, new RowMapper<Compra>() {
			public Compra  mapRow(ResultSet rs, int rowNum) throws SQLException {
				Compra compra = new Compra();
				compra.setId(rs.getInt("id"));
				compra.setAnumordcom(rs.getString("anumordcom"));
				compra.setCliente(rs.getString("cliente"));
				compra.setFormapago(rs.getString("formapago"));
				compra.setMoneda(rs.getString("moneda"));
				compra.setTotal(rs.getDouble("total"));
				compra.setEstado(rs.getString("estado"));
				compra.setAfecordcom(rs.getString("afecordcom"));
				
				return compra;
			}
		}, id);

		logger.info("compra: " + compra);
		
		return compra;
	}
	
	public void actualizar(Integer id) {
		logger.info("actualizar " + id);
		String sql = "UPDATE looccabecera_app SET estado='1' WHERE  estado='0' AND id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
}

