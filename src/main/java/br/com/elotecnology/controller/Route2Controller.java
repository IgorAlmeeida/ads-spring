package br.com.elotecnology.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;


@RestController
@RequestMapping("/route2")
public class Route2Controller {
	
	@GetMapping
	public ResponseEntity<Object> get () {

		List<Map<String, Object>> listOfMaps = null;
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ads","postgres", "fred");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			String query = "SELECT * FROM produto";
			
			QueryRunner queryRunner = new QueryRunner();
            listOfMaps = queryRunner.query(connection, query, new MapListHandler());
            
			return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(listOfMaps));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
