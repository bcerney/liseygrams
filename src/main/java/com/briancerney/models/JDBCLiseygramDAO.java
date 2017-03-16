package com.briancerney.models;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCLiseygramDAO implements LiseygramDAO{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCLiseygramDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Liseygram mapRowToGram(SqlRowSet row) {
		Liseygram gram = new Liseygram();
		gram.setOriginalSentence(row.getString("sentence"));
		return gram;
	}
	
	@Override
	public Liseygram getGramById(int id) {
		Liseygram gram = null;
		String sqlSelectGram = "SELECT sentence FROM sentences WHERE id="+id;
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectGram);
		if(result.next()) {
			gram = mapRowToGram(result);
		}
		return gram;
	}
	
	
	
}
