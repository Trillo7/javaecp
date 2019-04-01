package GestionEntidadesCoches.modelo;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GestionEntidadesCoches.modelo.entidades.Cliente;
import GestionEntidadesCoches.modelo.entidades.Coche;
import GestionEntidadesCoches.modelo.entidades.Fabricante;


public class ControladorBBDDCliente {

	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Cliente getClienteFromResultSet (ResultSet rs) {
		Cliente cliente = new Cliente();
		
		try {
			cliente.setId(rs.getInt("id"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setLocalidad(rs.getString("localidad"));
			cliente.setDniNie(rs.getString("dniNie"));
			cliente.setFechaNac(rs.getDate("fechaNac"));
			cliente.setActivo(rs.getBoolean("activo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getSiguienteCliente (Cliente clienteActual) {
		Cliente	clienteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente where id > ? order by id limit 1");
			ps.setInt(1, clienteActual.getId()); // conseguir los fabricantes que sean de id mayor que el que estamos
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clienteResultado = getClienteFromResultSet(rs);	// si hay alguno lo ajustamos al fabricante
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteResultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getAnteriorCliente (Cliente clienteActual) {
		Cliente	clienteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente where id < ? order by id desc limit 1");
			ps.setInt(1, clienteActual.getId()); // conseguir los fabricantes que sean de id mayor que el que estamos
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clienteResultado = getClienteFromResultSet(rs);	// si hay alguno lo ajustamos al fabricante
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteResultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getPrimerCliente() {
		Cliente cliente = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente order by id");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = getClienteFromResultSet(rs); // si hay alguno lo ajustamos al fabricante		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getUltimoCliente () {
		Cliente cliente = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = getClienteFromResultSet(rs); // si hay alguno lo ajustamos al fabricante		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean eliminarCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM tutorialjavacoches.cliente where id = ?");
			ps.setInt(1, cliente.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean guardarNuevoCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO tutorialjavacoches.cliente values (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getUltimoCliente().getId() + 1);
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getLocalidad());
			ps.setString(5, cliente.getDniNie());
			ps.setDate(6, new java.sql.Date(cliente.getFechaNac().getTime()));
			ps.setBoolean(7, cliente.isActivo());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean modificarCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "UPDATE tutorialjavacoches.cliente SET nombre = ?, apellidos = ?, localidad = ?, dniNie = ?, fechaNac = ?, activo= ?  where id = ?");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getLocalidad());
			ps.setString(4, cliente.getDniNie());
			ps.setDate(5, new java.sql.Date(cliente.getFechaNac().getTime()));
			ps.setBoolean(6, cliente.isActivo());
			ps.setInt(7, cliente.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
}
