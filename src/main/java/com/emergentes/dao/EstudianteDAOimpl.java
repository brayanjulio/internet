package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EstudianteDAOimpl extends ConexionDB implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ESTUDIANTES (NOMBRES, APELLIDOS, SEMINARIO, CONFIRMADO, FECHA) VALUES (?,?,?,?,?)");
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setString(4, estudiante.getConfirmado());
            ps.setString(5, estudiante.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ESTUDIANTES SET NOMBRES=?, APELLIDOS=?, SEMINARIO=?, CONFIRMADO=?, FECHA=? WHERE ID=?");
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setString(4, estudiante.getConfirmado());
            ps.setString(5, estudiante.getFecha());
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ESTUDIANTES WHERE ID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante est = new Estudiante();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ESTUDIANTES WHERE ID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setSeminario(rs.getString("seminario"));
                est.setConfirmado(rs.getString("confirmado"));
                est.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from estudiantes");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiante>();
            //adicionar valores obtenidos
            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setId(rs.getInt("id"));
                est.setNombres(rs.getString("nombres"));
                est.setApellidos(rs.getString("apellidos"));
                est.setSeminario(rs.getString("seminario"));
                est.setConfirmado(rs.getString("confirmado"));
                est.setFecha(rs.getString("fecha"));
                lista.add(est);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
