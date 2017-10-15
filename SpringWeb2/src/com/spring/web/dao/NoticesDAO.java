package com.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("noticesDao")
public class NoticesDAO {

	private NamedParameterJdbcTemplate jdbc;
    
	public NoticesDAO() {
		System.out.println("************NoticeDAO created***********");
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc); //for db connection 
		//get the property from beans dataSource
	}
	
	public List<Notice> getNotices() {
		return jdbc.query("select * from notices", new RowMapper<Notice>(){

			public Notice mapRow(ResultSet rs, int rownum) throws SQLException {
				Notice notice = new Notice();
				notice.setId(rs.getInt("id"));
				notice.setName(rs.getString("name"));
				notice.setEmail(rs.getString("email"));
				notice.setText(rs.getString("text"));
				return notice;
			}
		});
	}
	
	public Notice getNotice(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.queryForObject("select * from notices where id = :id", params, new RowMapper<Notice>(){

			public Notice mapRow(ResultSet rs, int rownum) throws SQLException {
				Notice notice = new Notice();
				notice.setId(rs.getInt("id"));
				notice.setText(rs.getString("text"));
				notice.setName(rs.getString("name"));
				notice.setEmail(rs.getString("email"));
				return notice;
			}		
		});	
	}
	
	public boolean create(Notice notice) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		String sql = "insert into notices (name,email,text) values (:name,:email,:text)";
		return jdbc.update(sql, params)==1;
	}
	/*
	

	@Transactional
	public int[] createBulk(List<Notice> notices) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());
		String sql = "insert into notices (name,email,text) values (:name,:email,:text)";
		return jdbc.batchUpdate(sql, params);
	}
	
	
	
	
	public boolean update(Notice notice) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
		String sql = "update notices set name=:name,email=:email,text=:text where id=:id";
		return jdbc.update(sql, params)==1;
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("delete from notices where id = :id", params)==1;
	}
	*/
	
}
