package com.amanda.project.DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.amanda.project.DTO.MemberDTO2;

public class MemberDAO {
	DataSource ds;
	public MemberDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			this.ds = (DataSource)env.lookup("jdbc");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection db_connect() throws Exception {
		return this.ds.getConnection();
	}
	public int updateMember(MemberDTO2 dto) throws Exception {
		String sql="update Members set pw=?,name=?,phone=?,email=?,zipcode=?,address1=?,address2=?  where id=? ";
		Connection con=this.db_connect();
		PreparedStatement pstat=con.prepareStatement(sql);
		pstat.setString(1,dto.getPw());
		pstat.setString(2,dto.getName());
		pstat.setString(3, dto.getBirth());
		pstat.setString(4, dto.getEmail());
		pstat.setString(5, dto.getPhone());
		pstat.setString(6, dto.getPhone());
		pstat.setString(7, dto.getId());	
		int result=pstat.executeUpdate();
		con.commit();
		con.close();
		return result;
	}

	public static String testSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}

}
