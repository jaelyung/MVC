package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.PersonDto;
import com.human.util.DBConn;

public class PersonDao {
	public int insert(PersonDto dto) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="insert into person values"+"(%d,'%s',%f,to_date('%s','yyyy-mm-dd hh24:mi:ss'),to_date('%s','yyyy-mm-dd hh24:mi:ss'))";
		sql=String.format(sql, dto.getNo(), dto.getName(), dto.getHeight(), DBConn.dateToString(dto.getBirth()),DBConn.dateToString(dto.getRegist()));
		
		
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	
	public int update(String name, int no) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="update person set name='%s' where no=%d";
		sql=String.format(sql, name, no);
		
		
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}

	public int delete(int no) {
		int returnValue=0;
		DBConn.getInstance();
		String sql="delete person where no=%d";
		sql=String.format(sql, no);
		
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbClose();
		return returnValue;
	}
	
	public ArrayList<PersonDto> select(){
		ArrayList<PersonDto> dtos=new ArrayList<PersonDto>();
		DBConn.getInstance();
		String sql="select * from person";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				PersonDto dto=new PersonDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setHeight(rs.getDouble("height"));
				dto.setBirth(rs.getTimestamp("birth"));
				dto.setRegist(rs.getTimestamp("regist"));
				
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	
	
	
	
	
	
}
