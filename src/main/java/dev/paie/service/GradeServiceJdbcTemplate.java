package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dev.paie.entite.Grade;
import javax.sql.DataSource;

@Component
public class GradeServiceJdbcTemplate implements GradeService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
	//??
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		this.jdbcTemplate.update(
		        "insert into grade (id, code, nbHeuresBase,tauxBase) values (NULL, ?, ?, ?)",
		        nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());
		
	}

	@Override
	public void mettreAJour(Grade grade) {
//		this.jdbcTemplate.update("update grade set code = ?,"+ "nbHeuresBase = ?,"+
//	" tauxBase = ?,"+" where id = ?", grade.getCode(), grade.getNbHeuresBase(),grade.getTauxBase(),grade.getId());
		String sql = "UPDATE grade SET code = ?, nbHeuresBase = ? , tauxBase = ? WHERE ID = ? ";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(),grade.getTauxBase(),grade.getId());
	}

	@Override
	public List<Grade> lister() {
		List<Grade> grades = this.jdbcTemplate.query(
		        "select id,code, nbHeuresBase, tauxBase from grade",
		        new RowMapper<Grade>() {
		            public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	Grade grade = new Grade();
		            	grade.setId(rs.getInt("id"));
		            	grade.setCode(rs.getString("code"));
		            	grade.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
		            	grade.setTauxBase(rs.getBigDecimal("tauxBase"));
		                return grade;
		            }
		        });
		return grades;
	}
}
